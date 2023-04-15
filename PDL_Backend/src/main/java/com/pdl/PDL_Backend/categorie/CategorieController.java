package com.pdl.PDL_Backend.categorie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;


import java.util.List;

@RestController
@RequestMapping(path = "/api/categorie_controller")
@RequiredArgsConstructor
public class CategorieController implements ICategorieController {
    private final CategorieService categorieService;

    @PostMapping(path = "/admin/add_categorie")
    @Override
    public ResponseEntity<?> addCategorie(@RequestBody Categorie categorie) throws Exception {
        try {
            boolean test = categorieService.addCategorie(categorie);
            if (test) {
                return new ResponseEntity<>(test, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(test, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            //exception.printStackTrace();
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/admin/update_categorie/{id}")
    @Override
    public ResponseEntity<?> updateCategorie(@PathVariable("id") Long id, @RequestBody Categorie categorie) throws Exception {
        try {
            boolean test = categorieService.updateCategorie(id, categorie);
            if (test) {
                return new ResponseEntity<>(test, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(test, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            //exception.printStackTrace();
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/categories")
    @Override
    public ResponseEntity<List<Categorie>> getAllCategories() {
        try {
            return new ResponseEntity<>(categorieService.getAllCategories(), HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/admin/delete_categorie/{id}")
    @Override
    public ResponseEntity<?> deleteCategorie(@PathVariable("id") Long id) throws Exception {
        try {
            return new ResponseEntity<>(categorieService.deleteCategorie(id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
