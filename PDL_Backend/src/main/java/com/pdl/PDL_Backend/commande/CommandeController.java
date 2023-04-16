package com.pdl.PDL_Backend.commande;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/commande_controller")
@RequiredArgsConstructor
public class CommandeController implements ICommandeCrud {
    private final CommandeService commandeService;

    @PostMapping(path = "/client/add_commande/{paye}")
    @Override
    public boolean addCommande(@RequestBody Commande commande, @PathVariable("paye") boolean paye) {
        try {
            return commandeService.addCommande(commande, paye);
        } catch (Exception exception) {
            return false;
        }
    }

    @PutMapping(path = "admin/update_commande/{id}")
    @Override
    public boolean updateCommande(@PathVariable("id") Long id, @RequestBody boolean deliveredAndPayed) {
        try {
            return commandeService.updateCommande(id, deliveredAndPayed);
        } catch (Exception exception) {
            return false;
        }
    }

    @GetMapping(path = "/commandes")
    @Override
    public List<Commande> getAllYourCommandes() {
        return commandeService.getAllYourCommandes();
    }

    @DeleteMapping(path = "client/delete_commande/{id}")
    @Override
    public boolean deleteCommande(@PathVariable("id") Long id) {
        try {
            return commandeService.deleteCommande(id);
        } catch (Exception exception) {
            return false;
        }
    }

    @GetMapping(path = "admin/commandes_livre")
    @Override
    public List<Commande> getAllCommandesAndDelivered() {
        return commandeService.getAllCommandesAndDelivered();
    }

    @GetMapping(path = "/admin/commandes_en_attentes")
    @Override
    public List<Commande> getAllCommandesWatingForPaiement() {
        return commandeService.getAllCommandesWatingForPaiement();
    }

    @GetMapping(path = "/admin/commandes_paye_non_livre")
    @Override
    public List<Commande> getAllCommandesPaiedAndNotDelivered() {
        return commandeService.getAllCommandesPaiedAndNotDelivered();
    }
}
