package com.pdl.PDL_Backend.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pdl.PDL_Backend.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String label;
    private String imageLink;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> productList;

    public Category(UUID id, String label, String imageLink) {
        this.id = id;
        this.label = label;
        this.imageLink = imageLink;
        productList = new ArrayList<>();
    }
}
