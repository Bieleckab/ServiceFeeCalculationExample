package com.dgtfactory.dgtfactoryassignment.transaction;


import java.util.List;

public interface TransactionService {
    /**
     *
     * @param id identifier of the client
     * @return List of all transactions of specific client
     */
    List<Transaction> getAllByClientId(Long id);

    /**
     *
     * @param id unique identificator used to get single transaction
     * @return single transaction
     */
    Transaction getById(Long id);

    /**
     *
     * @param transaction data to be saved
     * @return changed data of the transaction
     */
    Transaction save(Transaction transaction);

    /**
     *
     * @param transaction data to be saved
     * @param id identifier of which transaction data is going to be changed
     * @return changed transaction data
     */
    Transaction update(Transaction transaction, Long id);

    /**
     *
     * @param id identifier of transaction to be deleted
     */
    void delete(Long id);
}
