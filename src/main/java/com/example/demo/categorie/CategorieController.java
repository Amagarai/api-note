package com.example.demo.categorie;

import com.example.demo.user.UserRepository;
import com.example.demo.user.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        categorie.setDate(LocalDate.now());
        categorie.setUtilisation(0);
        categorie.setDetail(false);
        categorieRepository.save(categorie);
        //----Ajout sur la liste des categorie de la personne qui ajoute
        List<Categorie> list = user.getCategories();
        list.add(categorie);
        user.setCategories(list);
        userRepository.save(user);
        //--fin

        return categorie;
    }

    @GetMapping("list/{id}")
    public List<Categorie> ListeByUser(@PathVariable Long id){
        Utilisateur user = userRepository.findById(id).get();
        return user.getCategories();
    }

    @PutMapping("detail/{id}")
    public Categorie DetailCate(@PathVariable Long id){
        Categorie categorie = categorieRepository.findById(id).get();
        if (categorie.isDetail()){
            categorie.setDetail(false);
        }else {
            categorie.setDetail(true);
        }
        return categorieRepository.save(categorie);
    }
}
