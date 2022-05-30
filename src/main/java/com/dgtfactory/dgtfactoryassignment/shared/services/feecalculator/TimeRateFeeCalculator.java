package com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator;

import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;
import com.dgtfactory.dgtfactoryassignment.unitprice.UnitPrice;
import org.springframework.stereotype.Service;

@Service("TIME_RATE")
public class TimeRateFeeCalculator implements FeeCalculator {

    @Override
    public Double calculate(Transaction transaction) {
        //this is just a simple implementation example of fee calculation
        double fee = 0.0;
        double hours = transaction.getHours().doubleValue();

        for(UnitPrice unitPrice : transaction.getTransactionType().getUnitPrices()) {
            switch (unitPrice.getPriceRate()) {
                case HOUR:
                    fee += hours * unitPrice.getAmount();
                    break;
                case DAY:
                    fee += hours / 8 * unitPrice.getAmount();
                    break;
                case WEEK:
                    fee += Math.ceil(hours / 8 / 5) * unitPrice.getAmount();
                    break;
                case MONTH:
                    fee += Math.ceil(hours / 8 / 30) * unitPrice.getAmount();
                    break;
                case QUARTER:
                    fee += Math.ceil(hours / 8 / 30 / 4) * unitPrice.getAmount();
                    break;
                case YEAR:
                    fee += Math.ceil(hours / 8 / 365) * unitPrice.getAmount();
                    break;
            }
        }

        return fee;
    }
}
