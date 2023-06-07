package com.pdl.PDL_Backend.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("select p from Product p where p.category.id=?1")
    List<Product> findByCategoryId(UUID id);

    @Query("select p from Product p where p.quantity > ?1")
    List<Product> findAllAvailableProduct(int quantity);
}
