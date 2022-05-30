package com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator;

import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;
import org.springframework.stereotype.Service;

@Service("GRATIS")
public class GratisFeeCalculator implements FeeCalculator {

    @Override
    public Double calculate(Transaction transaction) {
        return 0.0;
    }
}
