package com.dgtfactory.dgtfactoryassignment.transaction;

import com.dgtfactory.dgtfactoryassignment.shared.enums.Currency;
import com.dgtfactory.dgtfactoryassignment.shared.enums.TransactionState;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionPostRequest {

    @NotBlank(message = "name is mandatory")
    private String name;

    private Integer hours;

    private Double amount;

    @Enumerated
    private TransactionState state;

    //@NotNull(message = "transactionTypeId is mandatory")
    private Long transactionTypeId;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionState getState() {
        return state;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "TransactionPostRequest{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", amount=" + amount +
                ", state=" + state +
                ", transactionTypeId=" + transactionTypeId +
                ", currency=" + currency +
                '}';
    }
}
