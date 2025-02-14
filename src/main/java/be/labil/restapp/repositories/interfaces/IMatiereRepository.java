package be.labil.restapp.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import be.labil.restapp.domain.entities.Matiere;

public interface IMatiereRepository extends JpaRepository<Matiere, Long> {

}
