package be.labil.restapp.domain.dtos;

import lombok.Value;

import java.io.Serializable;

@Value
public class UEDto implements Serializable {
    Long id;
    String intitule;
}
