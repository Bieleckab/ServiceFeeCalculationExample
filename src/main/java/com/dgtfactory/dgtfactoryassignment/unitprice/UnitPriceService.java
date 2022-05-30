package com.dgtfactory.dgtfactoryassignment.unitprice;


import java.util.List;

public interface UnitPriceService {
    /**
     *
     * @param id identifier of transaction (service) type
     * @return List of all unit prices belonging to service (transaction) type
     */
    List<UnitPrice> getAllByTransactionTypeId(Long id);

    /**
     *
     * @param id unique identificator used to get single unit price
     * @return single unit price
     */
    UnitPrice getById(Long id);

    /**
     *
     * @param unitPrice data to be saved
     * @return changed data of the unit price
     */
    UnitPrice save(UnitPrice unitPrice);

    /**
     *
     * @param unitPrice data to be changed
     * @param id identifier of which unit price data is going to be changed
     * @return changed unit price
     */
    UnitPrice update(UnitPrice unitPrice, Long id);

    /**
     *
     * @param id identifier of unit price to be deleted
     */
    void delete(Long id);
}
