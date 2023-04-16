package com.pdl.PDL_Backend.produit;

import com.pdl.PDL_Backend.categorie.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService implements ProduitCrud {
    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    @Override
    public boolean addProduit(Produit produit) throws Exception {
        if (produit == null) {
            throw new Exception("Product is null !");
        }
        var categorie = categorieRepository.findById(produit.getCategorie().getId()).orElseThrow(() -> new Exception("Categorie is not found !"));
        categorie.getProduits().add(produit);
        return produitRepository.save(produit) != null;
    }

    @Override
    public boolean updateProduit(Long id, Produit produit) throws Exception {
        if (produit == null) {
            throw new Exception("Product is null !");
        }
        if (id == null || id < 0) {
            throw new Exception("Product id is not valid !");
        }
        var foundProduit = produitRepository.findById(id).orElseThrow(() -> new Exception("Produit not found !"));
        if (produit.getLabel() != null) {
            if (produit.getLabel().isEmpty() == false && produit.getLabel().equals(foundProduit.getLabel()) == false) {
                foundProduit.setLabel(produit.getLabel());
            }
        }
        if (produit.getQuantite() != null) {
            if (produit.getQuantite() > 0 && produit.getQuantite().equals(foundProduit.getQuantite()) == false) {
                foundProduit.setQuantite(produit.getQuantite());
            }
        }
        if (produit.getPrix() != null) {
            if (produit.getPrix() > 0 && produit.getPrix().equals(foundProduit.getPrix()) == false) {
                foundProduit.setPrix(produit.getPrix());
            }
        }
        return produitRepository.save(foundProduit) != null;
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public boolean deleteProduit(Long id) throws Exception {
        if (id == null || id < 0) {
            throw new Exception("Product id is not valid !");
        }
        produitRepository.deleteById(id);
        return produitRepository.findById(id).orElse(null) == null;
    }
}
