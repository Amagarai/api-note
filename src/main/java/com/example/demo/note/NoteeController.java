package com.example.demo.note;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/note/")
public class NoteeController {
    @Autowired
    NoteServiceImp noteServiceImp;

    @PostMapping("add/{id}")
    public Note addNote(@RequestBody Note note,@PathVariable Long id){
        return noteServiceImp.addNote(note, id);
    }
}
