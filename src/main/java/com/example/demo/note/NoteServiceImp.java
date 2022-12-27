package com.example.demo.note;

import com.example.demo.Statut;
import com.example.demo.categorie.Categorie;
import com.example.demo.categorie.CategorieRepository;
import com.example.demo.user.UserRepository;
import com.example.demo.user.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImp implements NoteService{
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategorieRepository categorieRepository;

    //-------Add note
    @Override
    public Note addNote(Note note, Long id, Long id_cate) {
        Utilisateur user = userRepository.findById(id).get();
        Categorie categorie = categorieRepository.findById(id_cate).get();
        note.setCategorie(categorie);
        note.setStatut(Statut.Activer);
        note.setUtilisateur(user);
        noteRepository.save(note);
        //----ajout de la note a la liste des notes du user
        List<Note> list = user.getNotes();
        list.add(note);
        user.setNotes(list);
        userRepository.save(user);
        //--fin
        //----Incrementation du nombre d'utilisation de la categorie
        int categorie_use = note.getCategorie().getUtilisation();
        categorie_use = 1 + note.getCategorie().getUtilisation();
        note.getCategorie().setUtilisation(categorie_use);
        categorieRepository.save(note.getCategorie());
        return note;
    }


    //---Pour modifier le note ( ** pas de developper a mettre dans les perspective de l'appli peut-etre **)
    @Override
    public Note updateNote(Long id, Note note) {
        Note curentNote = noteRepository.findById(id).get();
        curentNote.setContenu(note.getContenu());
        return noteRepository.save(note);
    }

    //--------voir les detauls d'un note (** faire allongé le card sur le front **)
    @Override
    public Note viewDetail(Long id) {
        Note note = noteRepository.findById(id).get();
        if (note.isView()){
            note.setView(false);
        }else {
            note.setView(true);
        }

        return noteRepository.save(note);
    }

    //---------- changer le satut de d'une note...
    @Override
    public Note statut(Long id) {
        Note note = noteRepository.findById(id).get();
        note.setStatut(Statut.Delete);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> myNote(Long id) {
        Utilisateur utilisateur = userRepository.findById(id).get();
        List<Note> list = new ArrayList<>();
        for (int i = 0; i<utilisateur.getNotes().size(); i++){
            if (utilisateur.getNotes().get(i).getStatut() == Statut.Activer){
                list.add(utilisateur.getNotes().get(i));
                System.out.println(list);
            }
        }
        return list;
    }


}
