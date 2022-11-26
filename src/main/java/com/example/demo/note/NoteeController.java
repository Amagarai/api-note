package com.example.demo.note;


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
}
