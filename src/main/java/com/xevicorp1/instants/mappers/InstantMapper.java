package com.xevicorp1.instants.mappers;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.models.Instant;

// En els mappers no s'hi pot posar mai res optatiu, només l'obligatori.
public class InstantMapper {

    // Passem la info de Dto a Instant
    public Instant mapToInstant(InstantRequestDto instantDto){
        var instant = new Instant();
        instant.setTitle(instantDto.getTitle());
        instant.setDescription(instantDto.getDescription());
        instant.setImgUrl(instantDto.getImgUrl());
        instant.setLocation(instantDto.getLocation());
        return instant;
    }
}
