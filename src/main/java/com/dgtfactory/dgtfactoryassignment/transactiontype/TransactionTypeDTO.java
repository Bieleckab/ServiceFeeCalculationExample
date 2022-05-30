package com.dgtfactory.dgtfactoryassignment.transactiontype;

import com.dgtfactory.dgtfactoryassignment.shared.enums.FeeCalculation;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

public class TransactionTypeDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeeCalculation feeCalculation;

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

    public FeeCalculation getFeeCalculation() {
        return feeCalculation;
    }

    public void setFeeCalculation(FeeCalculation feeCalculation) {
        this.feeCalculation = feeCalculation;
    }

    @Override
    public String toString() {
        return "TransactionTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeCalculation=" + feeCalculation +
                '}';
    }
}
