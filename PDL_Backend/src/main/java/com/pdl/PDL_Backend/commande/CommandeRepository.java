package com.pdl.PDL_Backend.commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query("select c from Commande c where c.client.email=?1")
    List<Commande> findAllClientCommandes(String email);

    @Query("select c from Commande c where c.status=?1")
    List<Commande> findAllComandesByStatus(Status status);
}
