package com.pdl.PDL_Backend.product;

import com.pdl.PDL_Backend.category.CategorieRepository;
import com.pdl.PDL_Backend.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProduct {
    private final ProductRepository productRepository;
    private final CategorieRepository categorieRepository;

    @Override
    public List<Product> getAll() throws Exception {
        return productRepository.findAll();
    }

    @Override
    public String add(Product product) throws Exception {
        if (product == null) {
            throw new Exception("The product is null !");
        }
        Category found = categorieRepository.findById(product.getCategory().getId()).orElseThrow(() -> new Exception("The category id is mandatory !"));
        product.setCategory(found);
        productRepository.saveAndFlush(product);
        return "true";
    }

    @Override
    public String update(UUID id, Product product) throws Exception {
        Product found = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found !"));
        if (product.getLabel() != null) {
            if (!product.getLabel().isEmpty() && !product.getLabel().equals(found.getLabel())) {
                found.setLabel(product.getLabel());
            }
        }
        if (product.getQuantity() != null) {
            if (product.getQuantity() < 1 && !product.getQuantity().equals(found.getQuantity())) {
                found.setQuantity(product.getQuantity());
            }
        }
        if (product.getPrice() != null) {
            if (product.getPrice() < 1 && !product.getPrice().equals(found.getPrice())) {
                found.setPrice(product.getPrice());
            }
        }
        productRepository.saveAndFlush(found);
        return "true";
    }

    @Override
    public String delete(UUID id) throws Exception {
        Product found = productRepository.findById(id).orElseThrow(() -> new Exception("The product does not exist !"));
        productRepository.delete(found);
        productRepository.flush();
        return "true";
    }

    @Override
    public List<Product> getAllTheProductsOfASpecificCategory(UUID categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
