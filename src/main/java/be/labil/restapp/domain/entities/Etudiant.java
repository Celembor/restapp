package be.labil.restapp.domain.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ETUDIANT")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 10)
    private String matricule;

    @Column(length = 30)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 100)
    private String masterType;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private Set<Note> notes;

    private Double getMoyennePonderee() {
        if (notes == null || notes.isEmpty()) {
            return -1.0; // Retourne 0 si l'étudiant n'a pas de notes
        }

        double totalPoints = 0.0;
        double totalCredits = 0.0;

        for (Note note : notes) {
            totalPoints += note.getValeur() * note.getMatiere().getCredit();  // Valeur * Crédits
            totalCredits += note.getMatiere().getCredit();  // Somme des crédits
        }

        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    public String deliberation() {
        if (this.getMoyennePonderee() == -1.0) {
            return "Pas de notes disponibles pour l'étudiant";
        } else {
            return this.getMoyennePonderee() >= 10.0 ? "REUSSITE" : "ECHEC";
        }
    }

}
