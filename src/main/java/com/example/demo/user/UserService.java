package com.example.demo.user;

import com.example.demo.note.Note;

public interface UserService {
    public Utilisateur addUser(Utilisateur utilisateur);
    public Utilisateur updateUseer(Long id);
    public Utilisateur Login(String pseudo, String pass);

}
