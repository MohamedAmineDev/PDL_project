package com.pdl.PDL_Backend.produit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping(path = "/api/produit_controller")
@RequiredArgsConstructor
public class ProduitController implements ProduitCrud {
    private final ProduitService produitService;

    @PostMapping(path = "/admin/add_produit")
    @Override
    public boolean addProduit(@RequestBody Produit produit) {
        try {
            return produitService.addProduit(produit);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PutMapping(path = "/admin/update_produit/{id}")
    @Override
    public boolean updateProduit(@PathVariable("id") Long id, @RequestBody Produit produit) {
        try {
            return produitService.updateProduit(id, produit);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @GetMapping(path = "/produits")
    @Override
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @DeleteMapping(path = "/admin/delete_produit/{id}")
    @Override
    public boolean deleteProduit(@PathVariable("id") Long id) {
        try {
            return produitService.deleteProduit(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
