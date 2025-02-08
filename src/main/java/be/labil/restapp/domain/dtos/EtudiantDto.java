package be.labil.restapp.domain.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link be.labil.restapp.domain.entities.Etudiant}
 */
@Value
public class EtudiantDto implements Serializable {

    Long id;
    @NotNull(message = "Ce champ ne doit pas être vide")
    String matricule;
    String nom;
    String prenom;
    String masterType;

}
