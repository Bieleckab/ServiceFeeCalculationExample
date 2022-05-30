package com.dgtfactory.dgtfactoryassignment.shared.services.feecalculator;

import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;

@Service
public class FeeCalculatorServiceImpl implements FeeCalculatorService {

    private final BeanFactory beanFactory;

    public FeeCalculatorServiceImpl(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Double calculateFees(Transaction transaction) {
        FeeCalculator feeCalc = (FeeCalculator) this.beanFactory
                .getBean(transaction.getTransactionType().getFeeCalculation().name());

        return feeCalc.calculate(transaction);
    }
}
