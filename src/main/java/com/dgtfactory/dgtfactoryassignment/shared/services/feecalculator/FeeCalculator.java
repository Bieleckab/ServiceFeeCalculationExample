package com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator;

import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;

public interface FeeCalculator {

    Double calculate(Transaction transaction);
}
