package com.qa.rest;

import com.qa.domain.Note;
import com.qa.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {
    private final NoteService service;

    @Autowired
    public NotesController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/getAllNotes")
    public List<Note> getAllNotes (){
        return this.service.readNotes();
    }

    @PostMapping("/createNote")
    public Note createNote(@RequestBody Note note){
        return this.service.createNote(note);
    }

    @DeleteMapping("/deleteNote/{id}")
    public boolean deleteNote(@PathVariable Long id){
        return this.service.deleteNote(id);
    }
    @GetMapping("/getNoteById/{id}")
    public Note getNoteById(@PathVariable Long id){
        return this.service.findNoteById(id);
    }
    @PutMapping("/updateNote/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note){
        return this.service.updateNote(id,note);
    }


}
