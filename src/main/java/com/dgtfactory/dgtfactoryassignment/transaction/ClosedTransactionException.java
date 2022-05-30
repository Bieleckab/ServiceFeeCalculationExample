package com.dgtfactory.dgtfactoryassignment.transaction;

public class ClosedTransactionException extends RuntimeException {

    public ClosedTransactionException(Long id) {
        super("Transaction" + id + " is closed and therefore cannot be changed");
    }
}
