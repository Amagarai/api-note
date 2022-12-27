package com.example.demo.note;

import com.example.demo.Statut;
import com.example.demo.categorie.Categorie;
import com.example.demo.user.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String contenu;
    private LocalDate date;
    private boolean view;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @OneToOne
    private Categorie categorie;
    @ManyToOne
    @JsonIgnore
    private Utilisateur utilisateur;
}
