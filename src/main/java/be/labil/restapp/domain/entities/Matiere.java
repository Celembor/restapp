package be.labil.restapp.domain.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MATIERE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String intitule;

    private int credit;

    @ManyToOne
    @JoinColumn(name = "ue_id")
    private UE ue;

    @OneToMany(mappedBy = "matiere")
    private Set<Note> notes;

}
