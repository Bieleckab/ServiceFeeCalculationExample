package com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator;

import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;
import com.dgtfactory.dgtfactoryassignment.unitprice.UnitPrice;
import org.springframework.stereotype.Service;

@Service("FIXED")
public class FixedFeeCalculator implements FeeCalculator {

    @Override
    public Double calculate(Transaction transaction) {
        Double fee = 0.0;

        for(UnitPrice unitPrice: transaction.getTransactionType().getUnitPrices()) {
            fee += unitPrice.getAmount();
        }

        return fee;
    }
}
