package be.labil.restapp.domain.entities;

import java.util.Set;

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

}
