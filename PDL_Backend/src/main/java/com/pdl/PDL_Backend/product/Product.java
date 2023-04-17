package com.pdl.PDL_Backend.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pdl.PDL_Backend.category.Category;
import com.pdl.PDL_Backend.command_product.CommandProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String label;
    private Long quantity;
    private Double price;
    @ManyToOne
    private Category category;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<CommandProduct> commandProducts;

    public Product(@JsonProperty("id") UUID id, @JsonProperty("label") String label, @JsonProperty("quantity") Long quantity, @JsonProperty("price") Double price) {
        this.id = id;
        this.label = label;
        this.quantity = quantity;
        this.price = price;
        category = new Category();
        commandProducts = new ArrayList<>();
    }
}
