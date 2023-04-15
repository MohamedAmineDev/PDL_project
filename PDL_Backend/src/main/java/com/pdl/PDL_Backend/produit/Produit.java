package com.pdl.PDL_Backend.produit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pdl.PDL_Backend.categorie.Categorie;
import com.pdl.PDL_Backend.commande_produit.CommandeProduit;
import com.pdl.PDL_Backend.details_du_approvisionnement.DetailsDuApprovisionnement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private Double prix;
    private Long quantite;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Categorie categorie;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit")
    private List<DetailsDuApprovisionnement> detailsDuApprovisionnements;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit")
    private List<CommandeProduit> commandeProduits;
}
