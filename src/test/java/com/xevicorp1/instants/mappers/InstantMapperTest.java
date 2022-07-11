package com.xevicorp1.instants.mappers;

import com.xevicorp1.instants.dto.InstantRequestDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstantMapperTest {

    @Test
    void mapToInstant() {
        var instantRequest = InstantRequestDto.builder()
                .title("London")
                .description("Fantastic trip!")
                .imgUrl("london.jpeg")
                .location("London, Uk")
                .build(); // donar l'ordre perquè construeixi

        var sut = new InstantMapper().mapToInstant(instantRequest);

        assertEquals(sut.getTitle(), instantRequest.getTitle());
    }
}