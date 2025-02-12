package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.domain.mappers.INoteMapper;
import be.labil.restapp.repositories.interfaces.INoteRepository;
import be.labil.restapp.services.interfaces.INoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class NoteServiceImpl implements INoteService {

    private final INoteRepository iNoteRepository;
    private final INoteMapper iNoteMapper;

    @Override
    public Note insert(Note note) {
        return iNoteRepository.save(note);
    }

    @Override
    public Set<NoteDto> list() {
        Set<Note> noteSet = new LinkedHashSet<>();
        iNoteRepository.findAll().iterator().forEachRemaining(noteSet::add);
        return iNoteMapper.toDto(noteSet);
    }

    @Override
    public NoteDto update(Long id, NoteDto noteDto) {
        return iNoteRepository.findById(id).map(n -> {
            n.setValeur(noteDto.getValeur());
            Note updatedNote = iNoteRepository.save(n);
            log.warn("Mise à jour de la note {} effectuée avec succès", noteDto.getId());
            // Convertir l’entité mise à jour en DTO et retourner
            return iNoteMapper.toDto(updatedNote);
        }).orElseThrow(() -> new RuntimeException("Note inconnue"));
    }

    @Override
    public Boolean delete(Long id) {
        iNoteRepository.deleteById(id);
        return true;
    }
}
