package com.pdl.PDL_Backend.supply;

import com.pdl.PDL_Backend.supply_product.SupplyProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime interventionDate;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supply")
    private List<SupplyProduct> supplyProductList;
}
