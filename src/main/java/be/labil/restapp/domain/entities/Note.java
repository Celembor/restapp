package be.labil.restapp.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NOTE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double valeur;
    
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

}
