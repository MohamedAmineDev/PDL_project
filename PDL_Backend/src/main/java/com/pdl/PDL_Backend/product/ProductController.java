package com.pdl.PDL_Backend.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/product")
@RequiredArgsConstructor
public class ProductController implements IProduct {

    private final ProductService service;

    @GetMapping(path = "/products")
    @Override
    public List<Product> getAll() {
        try {
            return service.getAll();
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

    @GetMapping(path = "/available_products")
    public List<Product> getAllAvailableProduct() {
        return service.getAllAvailableProduct();
    }

    @PostMapping(path = "/admin/addition")
    @Override
    public String add(@RequestBody Product product) {
        try {
            return service.add(product);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @PutMapping(path = "/admin/update/{id}")
    @Override
    public String update(@PathVariable("id") UUID id, @RequestBody Product product) {
        try {
            return service.update(id, product);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping(path = "/admin/delete/{id}")
    @Override
    public String delete(@PathVariable("id") UUID id) {
        try {
            return service.delete(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @GetMapping(path = "/products/{id}")
    @Override
    public List<Product> getAllTheProductsOfASpecificCategory(@PathVariable("id") UUID categoryId) {
        try {
            return service.getAllTheProductsOfASpecificCategory(categoryId);
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }
}
