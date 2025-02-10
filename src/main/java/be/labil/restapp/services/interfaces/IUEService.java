package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.UEDto;
import be.labil.restapp.domain.entities.UE;

import java.util.Set;

public interface IUEService {

    UE insert(UE ue);

    Set<UEDto> list();

    UEDto update(Long id, UEDto ueDto);

    Boolean delete(Long id);

}
