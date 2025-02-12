package be.labil.restapp.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.labil.restapp.domain.entities.Matiere;

public interface IMatiereRepository extends JpaRepository<Matiere, Long> {

}
