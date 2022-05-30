package com.dgtfactory.dgtfactoryassignment.unitprice;

import com.dgtfactory.dgtfactoryassignment.shared.enums.PriceRate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class UnitPriceDTO {

    private Long id;

    @NotNull(message = "amount is mandatory")
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PriceRate priceRate;

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

    @Override
    public String toString() {
        return "UnitPriceDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", priceRate=" + priceRate +
                '}';
    }
}
