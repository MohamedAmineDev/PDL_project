package com.pdl.PDL_Backend.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pdl.PDL_Backend.command_product.CommandProduct;
import com.pdl.PDL_Backend.user.User;
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
@AllArgsConstructor
@NoArgsConstructor
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime createdAt;
    private Double totalPrice;
    private CommandType type;
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User client;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "command")
    private List<CommandProduct> commandProducts;
}
