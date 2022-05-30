package com.dgtfactory.dgtfactoryassignment.unitprice;

import com.dgtfactory.dgtfactoryassignment.shared.exceptions.ObjectWithIdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitPriceServiceImpl implements UnitPriceService {

    private final UnitPriceRepository repository;

    public UnitPriceServiceImpl(UnitPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UnitPrice> getAllByTransactionTypeId(Long id) {
        return this.repository.findAllByTransactionTypeId(id);
    }

    @Override
    public UnitPrice getById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() ->
                        new ObjectWithIdNotFoundException(id, "Unit price"));
    }

    @Override
    public UnitPrice save(UnitPrice unitPrice) {
        return this.repository.save(unitPrice);
    }

    @Override
    public UnitPrice update(UnitPrice unitPrice, Long id) {
        return this.repository
                .findById(id)
                .map(old -> {
                    old.setAmount(unitPrice.getAmount());
                    old.setPriceRate(unitPrice.getPriceRate());
                    return this.repository.save(old);
                })
                .orElseThrow(() ->
                        new ObjectWithIdNotFoundException(id, "Transaction type"));
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(this.repository.getById(id));
    }
}
