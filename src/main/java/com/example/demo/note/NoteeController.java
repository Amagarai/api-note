package com.example.demo.note;


import com.example.demo.categorie.Categorie;
import com.example.demo.categorie.CategorieRepository;
import com.example.demo.user.UserRepository;
import com.example.demo.user.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/note/")
public class NoteeController {
    @Autowired
    NoteServiceImp noteServiceImp;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("add/{id}/{id_cate}")
    public Note addNote(@RequestBody Note note,@PathVariable Long id, @PathVariable Long id_cate){
        return noteServiceImp.addNote(note, id, id_cate);
    }

    @GetMapping("mynote/{id}")
    public List<Note> ListNote(@PathVariable Long id){
        return noteServiceImp.myNote(id);
    }

    @GetMapping("{id}")
    public Note Detail(@PathVariable Long id){
        return noteRepository.findById(id).get();
    }

    @PutMapping("update/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note){
        return noteServiceImp.updateNote(id, note);
    }

    @PutMapping("delete/{id}")
    public Note delete(@PathVariable Long id){
        return noteServiceImp.statut(id);
    }

    @GetMapping("list")
    public List<Note> Liste(){
        return noteRepository.findAll();
    }

    @GetMapping("liste/{id}/{id_user}")
    public List<Note> noteParCategorie(@PathVariable Long id,@PathVariable Long id_user){
        Categorie categorie = categorieRepository.findById(id).get();
        Utilisateur utilisateur = userRepository.findById(id_user).get();
        return noteRepository.findByCategorieAndUtilisateur(categorie, utilisateur);
    }
}
