package com.example.demo.categorie;

import com.example.demo.user.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    public List<Categorie> findByUser(Utilisateur user);
}
