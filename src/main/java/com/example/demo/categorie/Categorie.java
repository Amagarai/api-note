package com.example.demo.categorie;

import com.example.demo.user.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate date;
    private int utilisation;
    private boolean detail;
    private String color;
    @ManyToOne
    private Utilisateur user;
}
