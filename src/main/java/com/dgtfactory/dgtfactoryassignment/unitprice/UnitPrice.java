package com.dgtfactory.dgtfactoryassignment.unitprice;

import com.dgtfactory.dgtfactoryassignment.shared.enums.PriceRate;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "UNIT_PRICE")
public class UnitPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "amount is mandatory")
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PriceRate priceRate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionType transactionType;

    public UnitPrice() {
    }

    public UnitPrice(Double amount, PriceRate priceRate) {
        this.amount = amount;
        this.priceRate = priceRate;
    }

    public UnitPrice(Double amount, PriceRate priceRate, TransactionType transactionType) {
        this.amount = amount;
        this.priceRate = priceRate;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PriceRate getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(PriceRate priceRate) {
        this.priceRate = priceRate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitPrice unitPrice = (UnitPrice) o;
        return Objects.equals(id, unitPrice.id) &&
                Objects.equals(amount, unitPrice.amount) &&
                priceRate == unitPrice.priceRate &&
                Objects.equals(transactionType, unitPrice.transactionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, priceRate, transactionType);
    }

    @Override
    public String toString() {
        return "UnitPrice{" +
                "id=" + id +
                ", amount=" + amount +
                ", priceRate=" + priceRate +
                '}';
    }
}
