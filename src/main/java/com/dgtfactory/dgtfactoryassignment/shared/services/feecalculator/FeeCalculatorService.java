package com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator;

import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;

public interface FeeCalculatorService {
    Double calculateFees(Transaction transaction);
}
