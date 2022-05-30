package com.dgtfactory.dgtfactoryassignment.transactiontype;


import java.util.List;

public interface TransactionTypeService {
    /**
     *
     * @return List of all transaction (service) types
     */
    List<TransactionType> getAll();

    /**
     *
     * @param id unique identificator used to get single transaction (service) type
     * @return single transaction (service) type
     */
    TransactionType getById(Long id);

    /**
     *
     * @param transactionType data to be saved
     * @return changed data of the transaction (service) type
     */
    TransactionType save(TransactionType transactionType);

    /**
     *
     * @param transactionType data to be changed
     * @param id identifier of which transaction (service) type data is going to be changed
     * @return changed transaction (service) type data
     */
    TransactionType update(TransactionType transactionType, Long id);

    /**
     *
     * @param id identifier of transaction (service) type to be deleted
     */
    void delete(Long id);
}
