package com.example.demo.note;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/note/")
public class NoteeController {
    @Autowired
    NoteServiceImp noteServiceImp;

    @PostMapping("add/{id}/{id_cate}")
    public Note addNote(@RequestBody Note note,@PathVariable Long id, @PathVariable Long id_cate){
        return noteServiceImp.addNote(note, id, id_cate);
    }

    @GetMapping("mynote/{id}")
    public List<Note> ListNote(@PathVariable Long id){
        return noteServiceImp.myNote(id);
    }
}
