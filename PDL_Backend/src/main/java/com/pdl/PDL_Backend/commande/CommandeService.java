package com.pdl.PDL_Backend.commande;

import com.pdl.PDL_Backend.commande_produit.CommandeProduit;
import com.pdl.PDL_Backend.commande_produit.CommandeProduitRepository;
import com.pdl.PDL_Backend.produit.ProduitRepository;
import com.pdl.PDL_Backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeService implements ICommandeCrud {
    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final UserRepository userRepository;
    private final CommandeProduitRepository commandeProduitRepository;

    @Override
    public boolean addCommande(Commande commande, boolean pay) throws Exception {
        if (commande == null) {
            throw new Exception("Commande is null !");
        }
        if (commande.getCommandeProduits() == null) {
            throw new Exception("The commande does not contains produits !");
        }
        for (CommandeProduit cp : commande.getCommandeProduits()
        ) {
            var foundProduct = produitRepository.findById(cp.getProduit().getId()).orElseThrow(() -> new Exception("Commande produit does not have a produit !"));
            foundProduct.setQuantite(foundProduct.getQuantite() - cp.getQuantite());
            produitRepository.save(foundProduct);
        }
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commande.setClient(userRepository.findByEmail(email).orElse(null));
        if (pay) {
            commande.setStatus(Status.PayeNonLivre);
        } else {
            commande.setStatus(Status.EnAttente);
        }
        commandeRepository.save(commande);
        return true;
    }

    @Override
    public boolean updateCommande(Long id, boolean deliveredAndPayed) throws Exception {
        if (id == null || id < 0) {
            throw new Exception("The id is not valid");
        }
        var foundCommande = commandeRepository.findById(id).orElseThrow(() -> new Exception("Command not found !"));
        if (deliveredAndPayed) {
            foundCommande.setStatus(Status.PayeLivre);
        }
        commandeRepository.save(foundCommande);
        return true;
    }

    @Override
    public List<Commande> getAllYourCommandes() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return commandeRepository.findAllClientCommandes(email);
    }

    @Override
    public boolean deleteCommande(Long id) throws Exception {
        if (id == null || id < 0) {
            throw new Exception("The id is not valid");
        }
        var foundCommande = commandeRepository.findById(id).orElseThrow(() -> new Exception("Commande was not found !"));
        List<CommandeProduit> commandProducts = commandeProduitRepository.getACommandDetails(id);
        if (!commandProducts.isEmpty()) {
            commandeProduitRepository.deleteAll(commandProducts);
        }
        commandeRepository.delete(foundCommande);
        return commandeRepository.findById(id).orElse(null) == null;
    }

    @Override
    public List<Commande> getAllCommandesAndDelivered() {
        return commandeRepository.findAllComandesByStatus(Status.PayeLivre);
    }

    @Override
    public List<Commande> getAllCommandesWatingForPaiement() {
        return commandeRepository.findAllComandesByStatus(Status.EnAttente);
    }

    @Override
    public List<Commande> getAllCommandesPaiedAndNotDelivered() {
        return commandeRepository.findAllComandesByStatus(Status.PayeNonLivre);
    }
}
