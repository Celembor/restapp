package be.labil.restapp.domain.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ETUDIANT")
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;
}
