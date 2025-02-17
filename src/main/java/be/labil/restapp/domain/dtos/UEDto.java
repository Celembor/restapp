package be.labil.restapp.domain.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

@Value
public class UEDto implements Serializable {
    Long id;
    String intitule;
    Set<MatiereDto> matieres;
}
