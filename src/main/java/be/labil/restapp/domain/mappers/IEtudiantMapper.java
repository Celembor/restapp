package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.entities.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel. SPRING )
public interface IEtudiantMapper extends IGenericMapper<EtudiantDto, Etudiant> {
    @Mapping(target = "deliberation", expression = "java(etudiant.deliberation())")
    EtudiantDto toDto(Etudiant etudiant);
    @Mapping(target = "deliberation", expression = "java(etudiant.deliberation())")
    Set<EtudiantDto> toDto(Set<Etudiant> entities);
}
