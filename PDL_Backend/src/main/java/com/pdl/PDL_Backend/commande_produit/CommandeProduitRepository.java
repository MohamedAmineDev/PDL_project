package com.pdl.PDL_Backend.commande_produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeProduitRepository extends JpaRepository<CommandeProduit, Long> {
    @Query("select cp from CommandeProduit cp where cp.commande.id=?1")
    List<CommandeProduit> getACommandDetails(Long id);
}
