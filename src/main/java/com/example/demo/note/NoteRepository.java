package com.example.demo.note;

import com.example.demo.Statut;
import com.example.demo.categorie.Categorie;
import com.example.demo.user.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    public List<Note> findByStatutAndUtilisateur(Statut statut, Utilisateur user);
    public List<Note> findByCategorie(Categorie categorie);
}
