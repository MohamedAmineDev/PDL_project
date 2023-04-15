package com.pdl.PDL_Backend.categorie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pdl.PDL_Backend.produit.Produit;
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
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private String imageLink;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
    private List<Produit> produits;
}
