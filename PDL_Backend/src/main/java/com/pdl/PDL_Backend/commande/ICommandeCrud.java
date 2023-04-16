package com.pdl.PDL_Backend.commande;

import java.util.List;

public interface ICommandeCrud {
    boolean addCommande(Commande commande, boolean paye) throws Exception;

    boolean updateCommande(Long id, boolean deliveredAndPayed) throws Exception;

    List<Commande> getAllYourCommandes();

    boolean deleteCommande(Long id) throws Exception;

    List<Commande> getAllCommandesAndDelivered();

    List<Commande> getAllCommandesWatingForPaiement();

    List<Commande> getAllCommandesPaiedAndNotDelivered();
}
