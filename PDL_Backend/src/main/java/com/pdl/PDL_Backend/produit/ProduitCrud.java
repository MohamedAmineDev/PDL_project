package com.pdl.PDL_Backend.produit;

import java.util.List;

public interface ProduitCrud {
    boolean addProduit(Produit produit) throws Exception;

    boolean updateProduit(Long id, Produit produit) throws Exception;

    List<Produit> getAllProduits();

    boolean deleteProduit(Long id) throws Exception;
}
