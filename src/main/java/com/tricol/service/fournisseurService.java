package com.tricol.service;

import com.tricol.entity.fournisseur;
import com.tricol.repository.fournisseurRepository;

import java.util.List;
import java.util.Optional;

public class fournisseurService {

    private final fournisseurRepository fournisseurRepository;

    public fournisseurService(fournisseurRepository fournisseurRepository) {
         this.fournisseurRepository = fournisseurRepository;
    }

    public  void save(fournisseur fournisseur) {
        fournisseurRepository.save(fournisseur);
    }

    public Optional<fournisseur> findById(int id) {
        Optional<fournisseur> fournisseur=fournisseurRepository.findById(id);;
        return fournisseur;
    }

    public List<fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public void delete(fournisseur fournisseur) {
        fournisseurRepository.delete(fournisseur);
    }

    public void update(fournisseur fournisseur) {
        fournisseurRepository.save(fournisseur);
    }

    public List<fournisseur> findByName(String name) {return fournisseurRepository.findByNom(name) ; };
    public fournisseur findByEmail(String email) {return fournisseurRepository.findByEmail(email) ;};




}
