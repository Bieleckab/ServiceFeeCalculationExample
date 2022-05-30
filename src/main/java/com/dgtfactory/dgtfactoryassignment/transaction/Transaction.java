package com.dgtfactory.dgtfactoryassignment.transaction;

import com.dgtfactory.dgtfactoryassignment.client.Client;
import com.dgtfactory.dgtfactoryassignment.shared.enums.Currency;
import com.dgtfactory.dgtfactoryassignment.shared.enums.TransactionState;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "name is mandatory")
    private String name;

    private Integer hours;

    @Column(nullable = false)
    private Double amount;

    @Enumerated
    @Column(nullable = false)
    private TransactionState state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Transaction(String name,
                       Integer hours,
                       TransactionState state,
                       Client client,
                       TransactionType transactionType,
                       Currency currency) {
        this.name = name;
        this.hours = hours;
        this.state = state;
        this.client = client;
        this.transactionType = transactionType;
        this.currency = currency;
    }

    public Transaction() {
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(hours, that.hours) &&
                Objects.equals(amount, that.amount) &&
                state == that.state && Objects.equals(client, that.client) &&
                Objects.equals(transactionType, that.transactionType) &&
                currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hours, amount, state, client, transactionType, currency);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", amount=" + amount +
                ", state=" + state +
                ", client=" + client +
                ", transactionType=" + transactionType +
                ", currency=" + currency +
                '}';
    }
}
