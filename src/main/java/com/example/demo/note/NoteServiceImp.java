package com.example.demo.note;

import com.example.demo.Statut;
import com.example.demo.user.UserRepository;
import com.example.demo.user.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImp implements NoteService{
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;


    //-------Add note
    @Override
    public Note addNote(Note note, Long id) {
        Utilisateur user = userRepository.findById(id).get();
        note.setStatut(Statut.EnCour);
        noteRepository.save(note);
        //----ajout de la note a la liste des notes du user
        List<Note> list = user.getNotes();
        list.add(note);
        user.setNotes(list);
        userRepository.save(user);
        return note;
    }


    //---Pour modifier le note ( ** pas de developper a mettre dans les perspective de l'appli peut-etre **)
    @Override
    public Note updateNote(Long id) {
        return null;
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
        note.setStatut(Statut.Terminer);
        return null;
    }


}
