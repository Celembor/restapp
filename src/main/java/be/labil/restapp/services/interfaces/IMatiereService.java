package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Matiere;

import java.util.Set;

public interface IMatiereService {

    Matiere insert(Matiere matiere);

    Set<MatiereDto> list();

    MatiereDto update(Long id, MatiereDto matiereDto);

    Boolean delete(Long id);

}
