package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Note;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel. SPRING )
public interface INoteMapper extends IGenericMapper<NoteDto, Note>{

}
