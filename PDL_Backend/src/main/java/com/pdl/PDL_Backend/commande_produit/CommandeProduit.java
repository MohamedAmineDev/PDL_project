package com.pdl.PDL_Backend.commande_produit;

import com.pdl.PDL_Backend.commande.Commande;
import com.pdl.PDL_Backend.produit.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantite;
    @ManyToOne(fetch = FetchType.LAZY)
    private Produit produit;
    @ManyToOne(fetch = FetchType.LAZY)
    private Commande commande;
}
