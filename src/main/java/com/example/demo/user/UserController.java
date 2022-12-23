package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    UserRepository userRepository;

    @PostMapping("add")
    public Utilisateur addUser(@RequestBody Utilisateur user){
        return userServiceImp.addUser(user);
    }
    @GetMapping("login/{pseudo}/{pass}")
    public Utilisateur Login(@PathVariable String pseudo, @PathVariable String pass){
        return userServiceImp.Login(pseudo, pass);
    }

    @GetMapping("{id}")
    public Utilisateur FindById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @PutMapping("new/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur user){
        return userServiceImp.updateCompte(user, id);
    }

    @PutMapping("update/{id}")
    public Utilisateur updatePass(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return userServiceImp.updatePass(id, utilisateur);
    }

    @GetMapping("list")
    public List<Utilisateur> Liste(){
        return userRepository.findAll();
    }
}
