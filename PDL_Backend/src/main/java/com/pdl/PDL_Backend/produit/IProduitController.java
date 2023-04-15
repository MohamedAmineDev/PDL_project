package com.pdl.PDL_Backend.produit;

import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

public interface IProduitController {
    EntityResponse<?> addProduit(Produit produit);

    EntityResponse<?> updateProduit(Long id, Produit produit);

    EntityResponse<List<Produit>> getAllProduits();

    List<Produit> deleteProduit(Long id);
}
