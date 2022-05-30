package com.dgtfactory.dgtfactoryassignment.unitprice;

import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionType;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UnitPriceController {

    private final UnitPriceService service;
    private final TransactionTypeService transactionTypeService;
    private final ModelMapper modelMapper;

    public UnitPriceController(
            UnitPriceService service,
            TransactionTypeService transactionTypeService,
            ModelMapper modelMapper) {
        this.service = service;
        this.transactionTypeService = transactionTypeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("transaction-types/{id}/unit-prices")
    public ResponseEntity<List<UnitPriceDTO>> getAllByTransTypeId(@PathVariable Long id) {
        List<UnitPriceDTO> unitPrices = this.service.getAllByTransactionTypeId(id)
                .stream()
                .map(unitPrice ->
                        this.modelMapper.map(unitPrice, UnitPriceDTO.class))
                .collect(Collectors.toList());

        if (unitPrices.size() > 0) {
            return ResponseEntity
                    .ok()
                    .body(unitPrices);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("transaction-types/{id}/unit-prices")
    @ResponseStatus(HttpStatus.CREATED)
    public UnitPriceDTO create(@Valid @RequestBody UnitPriceDTO unitPrice, @PathVariable Long id) {
        TransactionType transType = this.transactionTypeService
                .getById(id);

        UnitPrice newUnitPrice = this.modelMapper.map(unitPrice, UnitPrice.class);

        newUnitPrice.setTransactionType(transType);

        return this.modelMapper.map(this.service.save(newUnitPrice), UnitPriceDTO.class);
    }

    @GetMapping("transaction-types/{transTypeId}/unit-prices/{id}")
    public ResponseEntity<UnitPriceDTO> getById(@PathVariable Long id) {
        UnitPriceDTO unitPrice = this.modelMapper.map(this.service.getById(id), UnitPriceDTO.class);

        if (unitPrice != null) {
            return ResponseEntity
                    .ok()
                    .body(unitPrice);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("transaction-types/{transTypeId}/unit-prices/{id}")
    public UnitPriceDTO update(@Valid @RequestBody UnitPriceDTO unitPrice, @PathVariable Long id) {
        UnitPrice updatedUnitPrice = this.service.update(this.modelMapper.map(unitPrice, UnitPrice.class), id);

        return this.modelMapper.map(updatedUnitPrice, UnitPriceDTO.class);
    }

    @DeleteMapping("transaction-types/{transTypeId}/unit-prices/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
