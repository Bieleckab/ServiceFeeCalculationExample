package com.dgtfactory.dgtfactoryassignment.transaction;

import com.dgtfactory.dgtfactoryassignment.shared.enums.Currency;
import com.dgtfactory.dgtfactoryassignment.shared.enums.TransactionState;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class TransactionDTO {

    private Long id;

    private String name;

    private Integer hours;

    private Double amount;

    @Enumerated
    private TransactionState state;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Long transactionTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", amount=" + amount +
                ", state=" + state +
                ", currency=" + currency +
                ", transactionTypeId=" + transactionTypeId +
                '}';
    }
}
