package com.pdl.PDL_Backend.categorie;

import java.util.List;

public interface CategorieCrud {
    boolean addCategorie(Categorie categorie) throws Exception;

    boolean updateCategorie(Long id, Categorie categorie) throws Exception;

    List<Categorie> getAllCategories();

    boolean deleteCategorie(Long id) throws Exception;
}
