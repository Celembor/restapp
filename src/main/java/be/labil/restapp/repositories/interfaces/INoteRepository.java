package be.labil.restapp.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.labil.restapp.domain.entities.Note;

@Repository
public interface INoteRepository extends JpaRepository<Note, Long> {

}
