package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.services.interfaces.INoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Tag(name = "Note", description = "L'API des notes")
@RestController
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {

    public final INoteService iNoteService;

    @PostMapping(value = "/create", produces = "application/json")
    Note create(@RequestBody Note note) {
        return iNoteService.insert(note);
    }

    @GetMapping(value = "/list", produces = "application/json")
    Set<NoteDto> read() {
        return iNoteService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    NoteDto update(@PathVariable Long id, @RequestBody NoteDto noteDto) {
        return iNoteService.update(id, noteDto);
    }

    @DeleteMapping("/delete/{id}")
    Boolean delete(@PathVariable Long id) {
        return iNoteService.delete(id);
    }

}
