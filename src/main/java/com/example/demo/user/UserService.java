package com.example.demo.user;

import com.example.demo.note.Note;

import java.util.List;

public interface UserService {
    public Utilisateur addUser(Utilisateur utilisateur);
    public Utilisateur updateUseer(Long id);
    public Utilisateur Login(String pseudo, String pass);
    public Utilisateur updatePass(Long id, Utilisateur utilisateur);
}
