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
import java.util.Optional;

//import static org.hamcrest.Matchers.*; --> IMPORTAR TOTS ELS MATCHERS (*)
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class InstantServiceTest {

    // TEST DOUBLE --> Classes falsejades per cobrir el forat que deixa el repositori --> Mock
    // Utilitzem aquest Repo per fer els tests enlloc del Repo oficial
    // Mockegem un Repo que utilitzi la interfície de Repo que tenim creada
    // SUT = a la funció que testegem del InstantService
    // MOCKITO WHEN = a la funció utilitzada amb el Repo dins del mètode testejat
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
//        assertThat(sut.size(),equalTo(1) ); // Perquè falli
    }

    @Test
    void getByIdReturnsAnInstantWithSameId() {
        // GIVEN
        var instantService = new InstantService(mockInstantRepository);
        var instant = new Instant();
        instant.setId(1L);
        var id = 1L;

        Mockito.when(mockInstantRepository.findById(id)).thenReturn(Optional.of(instant));

        // SYSTEM UNDER TEST
        var sut = instantService.getById(id);

        // THEN
        assertThat(sut.getId(),equalTo(1L) );
//        assertThat(sut.getId(),equalTo(2L) ); // Perquè falli
    }

    @Test
    void createSaveANewInstantMappedFromDTO() {
        // GIVEN
        var instantService = new InstantService(mockInstantRepository);
        var instantRequest = new InstantRequestDto("London 2020","Fantastic city","lndn.jpg","London, UK");
        var creator = new User();
        creator.setId(1L);

        Instant instant = getInstant(creator); // Refactoritzat i mètode extret a sota del test

        Mockito.when(mockInstantRepository.save(any(Instant.class))).thenReturn(instant);

        // SYSTEM UNDER TEST
        var sut = instantService.create(instantRequest, creator);

        // THEN
        assertThat(sut.getCreator(),equalTo(creator));
//        assertThat(sut.getCreator(),equalTo(new User())); // Perquè falli
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

    @Test
    void updateSaveAnInstantMappedFromDTO() {
        // GIVEN
        var instantService = new InstantService(mockInstantRepository);
        var instantToEdit = new Instant();
        instantToEdit.setId(2L);
        var instantRequest = new InstantRequestDto("Finland 2020","Frozen place!","flnd.jpg","Helsinki, Finland");
        var id = 2L;

        Instant updatedInstant = getInstant(instantToEdit, instantRequest); // Refactoritzat i mètode extret a sota del test !!!

        Mockito.when(mockInstantRepository.findById(id)).thenReturn(Optional.of(instantToEdit));
        Mockito.when(mockInstantRepository.save(instantToEdit)).thenReturn(updatedInstant);

        // SYSTEM UNDER TEST --> EL QUE S'ESTÀ TESTEJANT, EQUIVALENT A UN RESULT
        var sut = instantService.update(instantRequest, id);

        // THEN
        assertThat(sut.getTitle(),equalTo(updatedInstant.getTitle()) );
//        assertThat(sut.getTitle(),equalTo(new Instant().getTitle()) ); // Perquè falli
    }

    private Instant getInstant(Instant instantToEdit, InstantRequestDto instantRequest) {
        var updatedInstant = new Instant();
        updatedInstant.setId(instantToEdit.getId());
        updatedInstant.setTitle(instantRequest.getTitle());
        updatedInstant.setDescription(instantRequest.getDescription());
        updatedInstant.setImgUrl(instantRequest.getImgUrl());
        updatedInstant.setLocation(instantRequest.getLocation());
        return updatedInstant;
    }

    @Test
    void deleteRemoveAnInstant() {
        var instantService = new InstantService(mockInstantRepository);
        var instant1 = new Instant();
        instant1.setId(1L);
        var instant2 = new Instant();
        instant2.setId(2L);
        var instant3 = new Instant();
        instant3.setId(3L);
        var instantList = List.of(instant1, instant2, instant3);
        var instantToDelete = new Instant();
        var id = 2L;
        instantToDelete.setId(id);

        Mockito.when(mockInstantRepository.findById(id)).thenReturn(Optional.of(instantToDelete));

        // SYSTEM UNDER TEST
        var sut = instantService.delete(2L);

        // THEN
        assertThat(sut,equalTo(instant2) );
//        assertThat(sut,equalTo(instant1) ); // perquè falli
    }

    @Test
    void findByTitleContainsOrDescriptionContains() {
        var instantService = new InstantService(mockInstantRepository);
        var instantRequest1 = new InstantRequestDto("London 2020","Fantastic city","lndn.jpg","London, UK");
        var instantRequest2 = new InstantRequestDto("Finland 2019","Frozen place!","flnd.jpg","Helsinki, Finland");
        var instantList = List.of(instantRequest1, instantRequest2);

//  S'HA D'UTILITZAR      Mockito.when(mockInstantRepository.findAll()).thenReturn(instantList);

        // SYSTEM UNDER TEST
        var sut = instantService.findByTitleContainsOrDescriptionContains("London");
        System.out.println(sut);
        assertThat(sut,equalTo(instantRequest2) );
//        assertThat(sut.size(),equalTo(instantRequest1) ); // Perquè falli
    }
}