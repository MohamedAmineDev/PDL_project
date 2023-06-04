package com.pdl.PDL_Backend;

import com.pdl.PDL_Backend.category.CategorieService;
import com.pdl.PDL_Backend.category.CategoryController;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class CategoryServiceConfiguration {
    @Bean
    @Primary
    public CategorieService categoryService() {
        return Mockito.mock(CategorieService.class);
    }
}
