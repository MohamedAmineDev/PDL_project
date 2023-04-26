package com.pdl.PDL_Backend.command_product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pdl.PDL_Backend.command.Command;
import com.pdl.PDL_Backend.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Command command;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public CommandProduct(@JsonProperty("id") UUID id, @JsonProperty("quantity") Long quantity) {
        this.id = id;
        this.quantity = quantity;
        command = new Command();
        product = new Product();
    }
}
