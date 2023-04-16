package com.pdl.PDL_Backend.command_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommandProductRepository extends JpaRepository<CommandProduct, UUID> {
}
