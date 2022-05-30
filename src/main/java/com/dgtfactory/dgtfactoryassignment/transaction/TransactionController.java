package com.dgtfactory.dgtfactoryassignment.transaction;

import com.dgtfactory.dgtfactoryassignment.client.Client;
import com.dgtfactory.dgtfactoryassignment.client.ClientService;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionType;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionTypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransactionController {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionService service;

    private final ClientService clientService;

    private final TransactionTypeService transactionTypeService;

    private final ModelMapper modelMapper;

    public TransactionController(
            TransactionService service,
            ClientService clientService,
            TransactionTypeService transactionTypeService,
            ModelMapper modelMapper) {
        this.service = service;
        this.clientService = clientService;
        this.transactionTypeService = transactionTypeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/clients/{id}/transactions")
    public ResponseEntity<List<TransactionDTO>> getAllByClientId(@PathVariable Long id) {
        List<TransactionDTO> transactions = this.service.getAllByClientId(id)
                .stream()
                .map(transaction ->
                        this.modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(transactions);
        }
    }

    @PostMapping("/clients/{id}/transactions")
    public TransactionDTO create(@Valid @RequestBody TransactionPostRequest transaction, @PathVariable Long id) {
        Client client = this.clientService.getById(id);
        TransactionType transactionType = this.transactionTypeService.getById(transaction.getTransactionTypeId());

        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Transaction newTransaction = this.modelMapper.map(transaction, Transaction.class);

        newTransaction.setClient(client);
        newTransaction.setTransactionType(transactionType);

        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper.map(this.service.save(newTransaction), TransactionDTO.class);
    }

    @GetMapping("clients/{clientId}/transactions/{id}")
    public ResponseEntity<TransactionDTO> getById(@PathVariable Long id) {
        TransactionDTO transaction = this.modelMapper.map(this.service.getById(id), TransactionDTO.class);

        if (transaction != null) {
            return ResponseEntity
                    .ok()
                    .body(transaction);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/clients/{idClient}/transactions/{id}")
    public TransactionDTO update(@RequestBody TransactionDTO transaction, @PathVariable Long id) {
        Transaction updatedTransaction = this.service.update(this.modelMapper.map(transaction, Transaction.class), id);

        return this.modelMapper.map(updatedTransaction, TransactionDTO.class);
    }

    @DeleteMapping("/clients/{clientId}/transactions/{id}")
    public void deleteById(@PathVariable Long id) {
        this.service.delete(id);
    }
}
