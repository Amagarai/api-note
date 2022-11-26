package com.example.demo.note;

import com.example.demo.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    public List<Note> findByStatut(Statut statut);
}
