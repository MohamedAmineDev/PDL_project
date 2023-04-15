package com.pdl.PDL_Backend.categorie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorieService implements CategorieCrud {
    private final CategorieRepository categorieRepository;

    @Override
    public boolean addCategorie(Categorie categorie) throws Exception {
        if (categorie == null) {
            throw new Exception("The categorie is null !");
        }
        return categorieRepository.save(categorie) != null;
    }

    @Override
    public boolean updateCategorie(Long id, Categorie categorie) throws Exception {
        if (categorie == null) {
            throw new Exception("The categorie is null !");
        }
        if (id == null || id < 0) {
            throw new Exception("The categorie's id  is not valid !");
        }
        var foundCategorie = categorieRepository.findById(id).orElseThrow(() -> new Exception("The categorie does not exist !"));
        if (categorie.getLabel() != null) {
            if (categorie.getLabel().isEmpty() == false && categorie.getLabel().equals(foundCategorie.getLabel()) == false) {
                foundCategorie.setLabel(categorie.getLabel());
            }
        }
        if (categorie.getImageLink() != null) {
            if (categorie.getImageLink().isEmpty() == false && categorie.getImageLink().equals(foundCategorie.getImageLink()) == false) {
                foundCategorie.setImageLink(categorie.getImageLink());
            }
        }
        return categorieRepository.save(foundCategorie) != null;
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public boolean deleteCategorie(Long id) throws Exception {
        if (id == null || id < 0) {
            throw new Exception("The categorie's id  is not valid !");
        }
        categorieRepository.deleteById(id);
        return categorieRepository.findById(id).orElse(null) == null;
    }
}
