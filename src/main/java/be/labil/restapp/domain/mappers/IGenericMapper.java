package be.labil.restapp.domain.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Set;

public interface IGenericMapper<D, E> {

    // Convertit un DTO en une entité
    E toEntity(D dto);

    // Convertit une entité en un DTO
    D toDto(E entity);

    // Met à jour partiellement une entité existante avec les valeurs non nulles d'un DTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E partialUpdate(D dto, @MappingTarget E entity);

    // Convertit un ensemble de DTOs en un ensemble d'entités
    Set<E> toEntity(Set<D> dtos);

    // Convertit un ensemble d'entités en un ensemble de DTOs
    Set<D> toDto(Set<E> entities);

    // Met à jour partiellement un ensemble d'entités avec les valeurs non nulles d'un ensemble de DTOs.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Set<E> partialUpdate(Set<D> dto, @MappingTarget Set<E> entity);

}
