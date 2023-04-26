package com.pdl.PDL_Backend.supply_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SupplyProductRepository extends JpaRepository<SupplyProduct, UUID> {
    @Query("select sp from SupplyProduct sp where sp.supply.id=?1")
    List<SupplyProduct> findBySupplyId(UUID id);
}
