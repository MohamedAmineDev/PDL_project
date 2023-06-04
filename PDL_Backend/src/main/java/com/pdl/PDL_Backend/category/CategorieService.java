package com.pdl.PDL_Backend.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategorieService implements ICategorie {
    private final CategorieRepository categorieRepository;

    @Override
    public List<Category> getAll() {
        try {
            return categorieRepository.findAll().stream().map(category -> new Category(category.getId(), category.getLabel(), category.getImageLink())).toList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public String add(Category category) {
        try {
            if (category == null) {
                throw new Exception("Category is null !");
            }
            categorieRepository.saveAndFlush(category);
            return "true";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "false";
        }
    }

    @Override
    public String update(UUID id, Category category) {
        try {
            Category found = categorieRepository.findById(id).orElseThrow(() -> new Exception("Category not found !"));
            if (category.getLabel() != null) {
                if (!category.getLabel().isEmpty() && !category.getLabel().equals(found.getLabel())) {
                    found.setLabel(category.getLabel());
                }
            }
            if (category.getImageLink() != null) {
                if (!category.getImageLink().isEmpty() && !category.getImageLink().equals(found.getImageLink())) {
                    found.setImageLink(category.getImageLink());
                }
            }
            categorieRepository.saveAndFlush(found);
            return "true";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "false";
        }
    }

    @Override
    public String delete(UUID id) {
        try {
            Category category = categorieRepository.findById(id).orElseThrow(() -> new Exception("The category does not exist !"));
            categorieRepository.delete(category);
            return "true";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "false";
        }
    }
}
