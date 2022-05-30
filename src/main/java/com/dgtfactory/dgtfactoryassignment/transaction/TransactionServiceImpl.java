package com.dgtfactory.dgtfactoryassignment.transaction;

import com.dgtfactory.dgtfactoryassignment.shared.enums.TransactionState;
import com.dgtfactory.dgtfactoryassignment.shared.exceptions.ObjectWithIdNotFoundException;
import com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator.FeeCalculatorService;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final FeeCalculatorService feeCalculatorService;
    private final TransactionTypeService transactionTypeService;

    public TransactionServiceImpl(
            TransactionRepository repository,
            FeeCalculatorService feeCalculatorService,
            TransactionTypeService transactionTypeService) {
        this.repository = repository;
        this.feeCalculatorService = feeCalculatorService;
        this.transactionTypeService = transactionTypeService;
    }

    @Override
    public List<Transaction> getAllByClientId(Long id) {
        List<Transaction> transactions = this.repository.findAllByClientId(id);

        for (Transaction transaction: transactions) {
            if (transaction.getState() == TransactionState.OPEN) {
                transaction.setAmount(this.feeCalculatorService.calculateFees(transaction));
            }
        }

        return transactions;
    }

    @Override
    public Transaction getById(Long id) {
        Transaction transaction = this.repository
                .findById(id)
                .orElseThrow(() ->
                        new ObjectWithIdNotFoundException(id, "Transaction"));

        if (transaction.getState() == TransactionState.OPEN) {
            transaction.setAmount(this.feeCalculatorService.calculateFees(transaction));
        }

        return transaction;
    }

    @Override
    public Transaction save(Transaction transaction) {
        transaction.setAmount(this.feeCalculatorService.calculateFees(transaction));

        return this.repository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction, Long id) {
        Transaction original = this.repository
                .findById(id)
                .orElseThrow(() -> new ObjectWithIdNotFoundException(id, "Transaction"));

        if (original.getState() == TransactionState.FINISHED) {
            throw new ClosedTransactionException(id);
        }

        original.setName(transaction.getName());
        original.setHours(transaction.getHours());
        original.setState(transaction.getState());
        original.setCurrency(transaction.getCurrency());

        if (!Objects.equals(original.getTransactionType().getId(), transaction.getTransactionType().getId())) {
            original.setTransactionType(this.transactionTypeService.getById(
                    transaction.getTransactionType().getId())
            );
        }

        original.setAmount(this.feeCalculatorService.calculateFees(original));

        return this.repository.save(original);
    }

    @Override
    public void delete(Long id) {
        Optional<Transaction> transaction = this.repository.findById(id);

        if (transaction.isEmpty()) {
            return;
        }

        if (transaction.get().getState() == TransactionState.OPEN) {
            this.repository.delete(transaction.get());
        } else {
            throw new ClosedTransactionException(id);
        }
    }
}
