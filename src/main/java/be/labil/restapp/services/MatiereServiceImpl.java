package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UE;
import be.labil.restapp.domain.mappers.IMatiereMapper;
import be.labil.restapp.repositories.interfaces.IMatiereRepository;
import be.labil.restapp.repositories.interfaces.IUERepository;
import be.labil.restapp.services.interfaces.IMatiereService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class MatiereServiceImpl implements IMatiereService {

    private final IMatiereRepository iMatiereRepository;
    private final IMatiereMapper iMatiereMapper;
    private final IUERepository iUeRepository;

    @Override
    public Matiere insert(Matiere matiere) {
        return iMatiereRepository.save(matiere);
    }

    @Override
    public Set<MatiereDto> list() {
        Set<Matiere> matiereSet = new LinkedHashSet<>();
        iMatiereRepository.findAll().iterator().forEachRemaining(matiereSet::add);
        return iMatiereMapper.toDto(matiereSet);
    }

    @Override
    public MatiereDto update(Long id, MatiereDto matiereDto) {
        return iMatiereRepository.findById(id).map(m -> {
            m.setIntitule(matiereDto.getIntitule());
            m.setCredit(matiereDto.getCredit());

            Matiere updatedMatiere = iMatiereRepository.save(m);
            log.warn("Mise à jour de la matière {} effectuée avec succès", matiereDto.getIntitule());
            // Convertir l’entité mise à jour en DTO et retourner
            return iMatiereMapper.toDto(updatedMatiere);
        }).orElseThrow(() -> new RuntimeException("Matière inconnue"));
    }

    @Override
    public Boolean delete(Long id) {
        if (!iMatiereRepository.existsById(id)) {
            throw new RuntimeException("Matière introuvable");
        }
        iMatiereRepository.deleteById(id);
        return true;
    }

    // Ajouter une matière à une UE
    public MatiereDto ajouterMatiereAUE(Long ueId, MatiereDto matiereDto) {
        UE ue = iUeRepository.findById(ueId).orElseThrow(() -> new RuntimeException("UE introuvable"));
        Matiere matiere = iMatiereMapper.toEntity(matiereDto);
        matiere.setUe(ue);
        Matiere savedMatiere = iMatiereRepository.save(matiere);
        return iMatiereMapper.toDto(savedMatiere);
    }
}
