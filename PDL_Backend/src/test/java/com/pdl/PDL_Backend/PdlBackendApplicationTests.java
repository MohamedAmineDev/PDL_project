package com.pdl.PDL_Backend;

import com.pdl.PDL_Backend.category.CategorieService;
import com.pdl.PDL_Backend.category.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class PdlBackendApplicationTests {
    @Autowired
    private CategorieService categoryService;

    @Test
    void contextLoads() {
    }

    @Test
    public void should_save_when_admin_add_a_valid_category() {
        Category category = new Category();
        category.setLabel("Test Unit Category Label");
        category.setImageLink("Test Unit Category Image Link");
        Mockito.when(categoryService.add(category)).thenReturn("true");
        String result = categoryService.add(category);
        Assert.assertEquals("true", result);

    }

    @Test
    public void should_not_save_when_admin_add_a_valid_category() {
        Category category = null;
        Mockito.when(categoryService.add(category)).thenReturn("false");
        String result = categoryService.add(category);
        Assert.assertEquals("false", result);

    }

    @Test
    public void should_load_a_list_of_category_that_is_not_null() {
        //Mockito.when(categorieService.getAll()).thenReturn(new ArrayList<>());
        var categories = categoryService.getAll();
        Assert.assertNotNull(categories);
    }

    @Test
    public void should_not_load_an_empty_list_of_category_that_is_not_null() {
        //Mockito.when(categoryService.getAll()).thenReturn(new ArrayList<>());
        var categories = categoryService.getAll();
        Assert.assertNotEquals("",3,categories.size());
    }

    @Test
    public void should_delete_a_category_that_we_had_specified_the_id() {
        Mockito.when(categoryService.delete(UUID.fromString("5a22c6f4-591b-4a8c-a4cf-e160a9fec00c"))).thenReturn("true");
        var deleted = categoryService.delete(UUID.fromString("5a22c6f4-591b-4a8c-a4cf-e160a9fec00c"));
        Assert.assertEquals("true", deleted);
    }

    @Test
    public void should_update_a_category_that_we_had_specified_the_id() {
        Category category = new Category();
        category.setLabel("c2");
        category.setImageLink("c2");
        Mockito.when(categoryService.update(UUID.fromString("5a22c6f4-591b-4a8c-a4cf-e160a9fec00c"), category)).thenReturn("true");
        var updated = categoryService.update(UUID.fromString("5a22c6f4-591b-4a8c-a4cf-e160a9fec00c"), category);
        Assert.assertEquals("true", updated);
    }

    @Test
    public void should_not_delete_a_category_that_we_had_specified_the_id() {
        Mockito.when(categoryService.delete(UUID.fromString("5a22c6f4-5555-4a8c-a4cf-e160a9fec00c"))).thenReturn("false");
        var deleted = categoryService.delete(UUID.fromString("5a22c6f4-5555-4a8c-a4cf-e160a9fec00c"));
        Assert.assertEquals("false", deleted);
    }

    @Test
    public void should_not_update_a_category_that_we_had_specified_the_id() {
        Category category = new Category();
        category.setLabel("c2");
        category.setImageLink("c2");
        Mockito.when(categoryService.update(UUID.fromString("5a22c6f4-5555-4a8c-a4cf-e160a9fec00c"), category)).thenReturn("false");
        var updated = categoryService.update(UUID.fromString("5a22c6f4-5555-4a8c-a4cf-e160a9fec00c"), category);
        Assert.assertEquals("false", updated);
    }
}
