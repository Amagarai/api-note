package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping("add")
    public Utilisateur addUser(@RequestBody Utilisateur user){
        return userServiceImp.addUser(user);
    }
    @GetMapping("login/{pseudo}/{pass}")
    public Utilisateur Login(@PathVariable String pseudo, @PathVariable String pass){
        return userServiceImp.Login(pseudo, pass);
    }

    @PutMapping("update/{id}")
    public Utilisateur updatePass(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return userServiceImp.updatePass(id, utilisateur);
    }
}
