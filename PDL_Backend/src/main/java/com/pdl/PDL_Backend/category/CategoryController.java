package com.pdl.PDL_Backend.category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/category")
@RequiredArgsConstructor
public class CategoryController implements ICategorie {
    private final CategorieService service;

    @GetMapping(path = "/categories")
    @Override
    public List<Category> getAll() {
        try {
            return service.getAll();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }

    @PostMapping(path = "/admin/addition")
    @Override
    public String add(@RequestBody Category category) {
        try {
            return service.add(category);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "false";
        }
    }

    @PutMapping(path = "/admin/update/{id}")
    @Override
    public String update(@PathVariable("id") UUID id, @RequestBody Category category) {
        try {
            return service.update(id, category);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "false";
        }

    }

    @DeleteMapping(path = "/admin/delete/{id}")
    @Override
    public String delete(@PathVariable("id") UUID id) {
        try {
            return service.delete(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "false";
        }

    }
}
