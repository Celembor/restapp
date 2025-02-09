package be.labil.restapp.domain.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MATIERE")
@Getter
@Setter
@NoArgsConstructor
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String intitule;

    private int credit;

    @ManyToOne
    private UE ue;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes = new LinkedHashSet<>();

}
