package com.pdl.PDL_Backend.categorie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

public interface ICategorieController {
    ResponseEntity<?> addCategorie(Categorie categorie) throws Exception;

    ResponseEntity<?> updateCategorie(Long id, Categorie categorie) throws Exception;

    ResponseEntity<List<Categorie>> getAllCategories();

    ResponseEntity<?> deleteCategorie(Long id) throws Exception;
}
