package com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator;

import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;
import org.springframework.stereotype.Service;

@Service("MIXED")
public class MixedFeeCalculator implements FeeCalculator {

    @Override
    public Double calculate(Transaction transaction) {
        //TODO - implementation of MIXED calculation of fees
        return 0.0;
    }
}
