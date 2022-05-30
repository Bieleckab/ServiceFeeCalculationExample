package com.dgtfactory.dgtfactoryassignment.transactiontype;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransactionTypeController {

    private final TransactionTypeService service;

    private final ModelMapper modelMapper;

    public TransactionTypeController(
            TransactionTypeService service,
            ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/transaction-types")
    public ResponseEntity<List<TransactionTypeDTO>> getAll() {
        List<TransactionTypeDTO> transactionTypes = this.service.getAll()
                .stream()
                .map(transactionType ->
                        this.modelMapper.map(transactionType, TransactionTypeDTO.class))
                .collect(Collectors.toList());

        if (transactionTypes.size() > 0) {
            return ResponseEntity
                    .ok()
                    .body(transactionTypes);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/transaction-types")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionTypeDTO create(@Valid @RequestBody TransactionTypeDTO transactionType) {
        TransactionType newTransactionType = this.service.save(
                this.modelMapper.map(transactionType, TransactionType.class)
        );

        return this.modelMapper.map(newTransactionType, TransactionTypeDTO.class);
    }

    @GetMapping("/transaction-types/{id}")
    public ResponseEntity<TransactionTypeDTO> getById(@PathVariable Long id) {
        TransactionTypeDTO transactionType = this.modelMapper.map(this.service.getById(id), TransactionTypeDTO.class);

        if (transactionType != null) {
            return ResponseEntity
                    .ok()
                    .body(transactionType);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/transaction-types/{id}")
    public TransactionTypeDTO update(@Valid @RequestBody TransactionTypeDTO transactionType, @PathVariable Long id) {
        TransactionType updatedTransType = this.service.update(
                this.modelMapper.map(transactionType, TransactionType.class),
                id
        );

        return this.modelMapper.map(updatedTransType, TransactionTypeDTO.class);
    }

    @DeleteMapping("/transaction-types/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
