package com.pdl.PDL_Backend.details_du_approvisionnement;

import com.pdl.PDL_Backend.approvisionnement.Approvisionnement;
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
public class DetailsDuApprovisionnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantite;
    @ManyToOne(fetch = FetchType.LAZY)
    private Produit produit;
    @ManyToOne(fetch = FetchType.LAZY)
    private Approvisionnement approvisionnement;
}
