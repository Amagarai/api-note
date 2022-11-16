package com.example.demo.categorie;

import com.example.demo.user.UserRepository;
import com.example.demo.user.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cate")
public class CategorieController {
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("add/{id}")
    public Categorie add(@RequestBody Categorie categorie,@PathVariable Long id){
        Utilisateur user = userRepository.findById(id).get();
        categorieRepository.save(categorie);
        List<Categorie> list = user.getCategories();
        list.add(categorie);
        user.setCategories(list);
        userRepository.save(user);
        return categorie;
    }

    @GetMapping("list/{id}")
    public List<Categorie> ListeByUser(@PathVariable Long id){
        Utilisateur user = userRepository.findById(id).get();
        return user.getCategories();
    }
}
