package be.labil.restapp.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import be.labil.restapp.domain.entities.Note;

public interface INoteRepository extends JpaRepository<Note, Long> {

}
