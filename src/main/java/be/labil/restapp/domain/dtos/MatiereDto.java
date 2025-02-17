package be.labil.restapp.domain.dtos;

import lombok.Value;

import java.io.Serializable;

@Value
public class MatiereDto implements Serializable {
    Long id;
    String intitule;
    int credit;
}
