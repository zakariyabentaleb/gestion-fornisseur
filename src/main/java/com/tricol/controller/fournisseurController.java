package com.tricol.controller;

import com.tricol.entity.fournisseur;
import com.tricol.service.fournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fournisseurs")
public class fournisseurController {


    private fournisseurService fournisseurService;

    public fournisseurController(fournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping
    public String createFournisseur(@RequestBody fournisseur fournisseur) {
        fournisseurService.save(fournisseur);
        return "Fournisseur ajouté avec succès" + fournisseur;
    }

    @GetMapping
    public List<fournisseur> getAllFournisseur() {
        return fournisseurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<fournisseur> getFournisseurById(@PathVariable("id") int id) {
        Optional<fournisseur> fournisseur = fournisseurService.findById(id);
        return fournisseur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deleteFournisseurById(@PathVariable int id) {
        Optional<fournisseur> fournisseur = fournisseurService.findById(id);
        if (fournisseur.isPresent()) {
            fournisseurService.delete(fournisseur.get());
            return "Fournisseur supprimé avec succès";
        } else {
            return "Fournisseur non trouvé";
        }
    }

    @PutMapping("/{id}")
    public String updateFournisseur(@PathVariable int id, @RequestBody fournisseur fournisseur) {
        Optional<fournisseur> existingOpt = fournisseurService.findById(id);
        if (existingOpt.isPresent()) {
            fournisseur existing = existingOpt.get();
            existing.setIce(fournisseur.getIce());
            existing.setNom(fournisseur.getNom());
            existing.setSociete(fournisseur.getSociete());
            existing.setAdresse(fournisseur.getAdresse());
            existing.setTelephone(fournisseur.getTelephone());
            existing.setEmail(fournisseur.getEmail());
            existing.setVille(fournisseur.getVille());

            fournisseurService.update(existing);
            return "Fournisseur mis à jour avec succès";
        } else {
            return "Fournisseur non trouvé";
        }
    }

    @GetMapping("/nom")
    public ResponseEntity<List<fournisseur>> getFournisseurByNom(@RequestParam("nom") String nom) {
        List<fournisseur> fournisseurs = fournisseurService.findByName(nom);
        return ResponseEntity.ok(fournisseurs);
    }

    @GetMapping("/email")
    public fournisseur getFournisseurByEmail(@RequestParam("email") String email) {
        return fournisseurService.findByEmail(email);
    }

}