package com.pdl.PDL_Backend.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategorieRepository extends JpaRepository<Category, UUID> {
}
