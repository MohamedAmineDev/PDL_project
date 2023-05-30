package com.pdl.PDL_Backend.supply_product;

import com.pdl.PDL_Backend.product.Product;
import com.pdl.PDL_Backend.supply.Supply;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Supply supply;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
}
