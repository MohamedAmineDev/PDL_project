package com.pdl.PDL_Backend.commande;

import com.pdl.PDL_Backend.commande_produit.CommandeProduit;
import com.pdl.PDL_Backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateCreation;
    private Status status;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commande")
    private List<CommandeProduit> commandeProduits;
    @ManyToOne(fetch = FetchType.LAZY)
    private User client;
}
