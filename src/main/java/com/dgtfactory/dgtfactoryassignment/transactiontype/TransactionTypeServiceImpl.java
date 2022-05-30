package com.dgtfactory.dgtfactoryassignment.transactiontype;

import com.dgtfactory.dgtfactoryassignment.shared.exceptions.ObjectWithIdNotFoundException;
import com.dgtfactory.dgtfactoryassignment.unitprice.UnitPrice;
import com.dgtfactory.dgtfactoryassignment.unitprice.UnitPriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    private final TransactionTypeRepository repository;

    public TransactionTypeServiceImpl(TransactionTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TransactionType> getAll() {
        return this.repository.findAll();
    }

    @Override
    public TransactionType getById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() ->
                        new ObjectWithIdNotFoundException(id, "Transaction type"));
    }

    @Override
    public TransactionType save(TransactionType transactionType) {
        return this.repository.save(transactionType);
    }

    @Override
    public TransactionType update(TransactionType transactionType, Long id) {
        return this.repository
                .findById(id)
                .map(old -> {
                    old.setName(transactionType.getName());
                    old.setFeeCalculation(transactionType.getFeeCalculation());
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
