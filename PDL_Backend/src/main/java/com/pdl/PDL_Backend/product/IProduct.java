package com.pdl.PDL_Backend.product;

import java.util.List;
import java.util.UUID;

public interface IProduct {
    List<Product> getAll() throws Exception;

    String add(Product product) throws Exception;

    String update(UUID id, Product product) throws Exception;

    String delete(UUID id) throws Exception;

    List<Product> getAllTheProductsOfASpecificCategory(UUID categoryId);
}
