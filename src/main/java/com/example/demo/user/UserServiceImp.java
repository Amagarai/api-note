package com.example.demo.user;

import com.example.demo.note.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public Utilisateur addUser(Utilisateur utilisateur) {
        return userRepository.save(utilisateur);
    }

    @Override
    public Utilisateur updateUseer(Long id) {
        Utilisateur user = userRepository.findById(id).get();
        return null;
    }
    @Override
    public Utilisateur Login(String pseudo, String pass) {
        return userRepository.findByPseudoAndPassword(pseudo, pass);
    }

    @Override
    public Utilisateur updatePass(Long id, Utilisateur utilisateur) {
        Utilisateur exitant = userRepository.findById(id).get();
        exitant.setPassword(utilisateur.getPassword());
        return userRepository.save(exitant);
    }
}
