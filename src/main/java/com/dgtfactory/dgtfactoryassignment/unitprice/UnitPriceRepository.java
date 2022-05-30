package com.dgtfactory.dgtfactoryassignment.unitprice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitPriceRepository extends JpaRepository<UnitPrice, Long> {

    List<UnitPrice> findAllByTransactionTypeId(Long id);
}
