package com.tricol.repository;

import com.tricol.entity.fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  fournisseurRepository extends JpaRepository<fournisseur,Integer> {
    public List<fournisseur> findByNom(String nom);

    @Query("SELECT fr FROM fournisseur fr WHERE fr.email ILIKE  %?1")
    public fournisseur findByEmail(String email);

}
