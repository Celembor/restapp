package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Note;

import java.util.Set;

public interface INoteService {

    Note insert(Note note);

    Set<NoteDto> list();

    NoteDto update(Long id, NoteDto noteDto);

    Boolean delete(Long id);

}
