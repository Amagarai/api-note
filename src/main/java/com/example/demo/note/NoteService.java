package com.example.demo.note;

import com.example.demo.user.Utilisateur;

import java.util.List;

public interface NoteService {
    public Note addNote(Note note, Long id, Long id_cate);
    public Note updateNote(Long id, Note note);
    public Note viewDetail(Long id);
    public Note statut(Long id);
    public List<Note> myNote(Long id);
}
