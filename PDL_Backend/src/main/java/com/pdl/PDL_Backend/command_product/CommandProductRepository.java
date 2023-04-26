package com.pdl.PDL_Backend.command_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommandProductRepository extends JpaRepository<CommandProduct, UUID> {
    @Query("select cp from CommandProduct cp where cp.command.id=?1")
    List<CommandProduct> getDetails(UUID id);
}
