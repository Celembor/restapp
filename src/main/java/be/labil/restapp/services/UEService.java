package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.UEDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UE;
import be.labil.restapp.domain.mappers.IMatiereMapper;
import be.labil.restapp.domain.mappers.IUEMapper;
import be.labil.restapp.repositories.interfaces.IUERepository;
import be.labil.restapp.services.interfaces.IUEService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UEService implements IUEService {

    private final IUERepository iUeRepository;
    private final IUEMapper iUeMapper;
    private final IMatiereMapper iMatiereMapper;

    @Override
    public UE insert(UE ue) {
        log.info("Insertion de l'UE {}", ue.getIntitule());
        return iUeRepository.save(ue);
    }

    @Override
    public Set<UEDto> list() {
        log.info("Récupération de toutes les UEs");
        Set<UE> UESet = new LinkedHashSet<>();
        iUeRepository.findAll().iterator().forEachRemaining(UESet::add);
        return iUeMapper.toDto(UESet);
    }

    @Override
    public UEDto update(Long id, UEDto ueDto) {
        return iUeRepository.findById(id).map(ue -> {
            // Mettre à jour les propriétés de l'UE avec les valeurs du DTO
            ue.setIntitule(ueDto.getIntitule());

            // Convertir les DTOs des matières en entités et mettre à jour la collection
            Set<Matiere> matieres = ueDto.getMatieres().stream()
                    .map(iMatiereMapper::toEntity)
                    .collect(Collectors.toSet());
            ue.setMatieres(matieres);

            // Sauvegarder l’entité mise à jour
            UE updatedUE = iUeRepository.save(ue);
            log.info("Mise à jour de l'UE {} effectuée avec succès", ueDto.getIntitule());

            // Convertir l’entité mise à jour en DTO et retourner
            return iUeMapper.toDto(updatedUE);
        }).orElseThrow(() -> new RuntimeException("UE inconnue"));
    }

    @Override
    public Boolean delete(Long id) {
        if (iUeRepository.existsById(id)) {
            iUeRepository.deleteById(id);
            log.info("Suppression de l'UE avec l'id {}", id);
            return true;
        }
        log.warn("Tentative de suppression d'une UE inconnue avec l'id {}", id);
        return false;
    }
}
