package com.example.demo.user;

import com.example.demo.categorie.Categorie;
import com.example.demo.note.Note;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pseudo;
    private String password;
    private String nomComplet;
    private String numero;
    private LocalDate date;
    @OneToMany

    private List<Note> notes = new ArrayList<>();
    @OneToMany
    private List<Categorie> categories = new ArrayList<>();
}
