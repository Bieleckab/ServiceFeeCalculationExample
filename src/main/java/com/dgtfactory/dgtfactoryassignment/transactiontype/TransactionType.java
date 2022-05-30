package com.dgtfactory.dgtfactoryassignment.transactiontype;

import com.dgtfactory.dgtfactoryassignment.shared.enums.FeeCalculation;
import com.dgtfactory.dgtfactoryassignment.unitprice.UnitPrice;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION_TYPE")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeeCalculation feeCalculation;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "transaction_type_id")
    private List<UnitPrice> unitPrices = new ArrayList<>();

    public TransactionType() {
    }

    public TransactionType(String name, FeeCalculation feeCalculation) {
        this.name = name;
        this.feeCalculation = feeCalculation;
    }

    public TransactionType(String name, FeeCalculation feeCalculation, List<UnitPrice> unitPrices) {
        this.name = name;
        this.feeCalculation = feeCalculation;
        this.unitPrices = unitPrices;
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

    public List<UnitPrice> getUnitPrices() {
        return unitPrices;
    }

    public void setUnitPrices(List<UnitPrice> unitPrices) {
        this.unitPrices = unitPrices;
    }

    public FeeCalculation getFeeCalculation() {
        return feeCalculation;
    }

    public void setFeeCalculation(FeeCalculation feeCalculation) {
        this.feeCalculation = feeCalculation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionType that = (TransactionType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(unitPrices, that.unitPrices) &&
                feeCalculation == that.feeCalculation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unitPrices, feeCalculation);
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeCalculation=" + feeCalculation +
                ", unitPrices=" + unitPrices +
                '}';
    }
}
