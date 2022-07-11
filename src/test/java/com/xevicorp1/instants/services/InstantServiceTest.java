package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.IInstantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//import static org.hamcrest.Matchers.*; --> IMPORTAR TOTS ELS MATCHERS (*)
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class InstantServiceTest {

    // TEST DOUBLE --> CLASSES FALSEJADES PER COBRIR EL FORAT QUE DEIXA EL REPOSITORY (MOCK)
    // FEMR SERVIR AQUEST REPO PER FER TESTS ENLLOC DEL BO
    // MOCKEGEM UN REPO QUE FACI SERVIR LA INTERFÍCIE DE REPO QUE JA TENIM
    // SUT S'IGUALA A LA FUNCIÓ QUE FEM SERVIR AMB EL REPO DINS DEL MÈTODE
    @Mock
    IInstantRepository mockInstantRepository;

    @Test
    void getAllReturnsListOfInstants() {
        // GIVEN
        var instantService = new InstantService(mockInstantRepository);

        var instantList = List.of(new Instant(), new Instant());

        Mockito.when(mockInstantRepository.findAll()).thenReturn(instantList);

        // SYSTEM UNDER TEST --> EL QUE S'ESTÀ TESTEJANT, EQUIVALENT A UN RESULT
        var sut = instantService.getAll();

        // THEN
        assertThat(sut.size(),equalTo(2) );
//        assertThat(sut.size(),equalTo(1) ); // Per comprovar que falla
    }

//    @Test
//    void getInstantCalledByItsId() {
//        // GIVEN
//        var instantService = new InstantService(mockInstantRepository);
//        var instantList = List.of(new Instant(), new Instant());
//        Mockito.when(mockInstantRepository.findAll()).thenReturn(instantList);
//
//        // SYSTEM UNDER TEST --> EL QUE S'ESTÀ TESTEJANT, EQUIVALENT A UN RESULT
//        var sut = instantService.getAll();
//
//        // THEN
//        assertThat(sut.size(),equalTo(2) );
//    }

    @Test
    void createSaveANewInstantMappedFromDTO() {
        // GIVEN
        var instantService = new InstantService(mockInstantRepository);

        var instantRequest = new InstantRequestDto("London 2020","Fantastic city","lndn.jpg","London, UK");
        var creator = new User();
        creator.setId(1L);

        Instant instant = getInstant(creator); // Refactoritzat i mètode extret a fora del test (fila 83)

        Mockito.when(mockInstantRepository.save(any(Instant.class))).thenReturn(instant);

        // SYSTEM UNDER TEST
        var sut = instantService.create(instantRequest, creator);

        // THEN
        assertThat(sut.getCreator(),equalTo(creator));
//        assertThat(sut.getCreator(),equalTo(new User())); // Per comprovar que falla
    }

    private Instant getInstant(User creator) {
        var instant = new Instant();
        instant.setId(1L);
        instant.setTitle("London 2020");
        instant.setDescription("Fantastic city");
        instant.setImgUrl("lndn.jpg");
        instant.setLocation("London, UK");
        instant.setCreator(creator);
        return instant;
    }

//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void findByTitleContainsOrDescriptionContains() {
//    }
}