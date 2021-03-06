package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.exceptions.NotFoundException;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.IInstantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstantService implements IInstantService {
    private IInstantRepository instantRepository;

    public InstantService(IInstantRepository instantRepository) {
        this.instantRepository = instantRepository;
    }

    @Override
    public List<Instant> getAll() {
        return instantRepository.findAll();
    }

//    @Override
//    public Instant getById(Long id) {
//        var instant = instantRepository.findById(id).get();
//        return instant;
//    }

    // PER LA GESTIÓ D'ERRORS --> OPTIONAL+EMPTY/PRESENT+THROW+RUNTIME EXCEPTION
//    @Override
//    public Instant getById(Long id) {
//        var opInstant = instantRepository.findById(id);
//        if(opInstant.isEmpty()) throw new RuntimeException("Instant Not Found");
//        return opInstant.get();
//    }

    // PER LA GESTIÓ D'ERRORS --> EXCEPTION PERSONALITZADA
    @Override
    public Instant getById(Long id) {
        var opInstant = instantRepository.findById(id);
        if(opInstant.isEmpty()) throw new NotFoundException("Instant Not Found","P-153");

        return opInstant.get();
    }

    @Override
    public Instant create(InstantRequestDto instantDto, User auth) {
        var newInstant = new Instant();
        newInstant.setTitle(instantDto.getTitle());
        newInstant.setDescription(instantDto.getDescription());
        newInstant.setImgUrl(instantDto.getImgUrl());
        newInstant.setLocation(instantDto.getLocation());
        newInstant.setCreator(auth);
        return instantRepository.save(newInstant);
    }

    @Override
    public Instant update(InstantRequestDto instantDto, Long id) {
        var instantToEdit = instantRepository.findById(id).get();
        instantToEdit.setTitle(instantDto.getTitle());
        instantToEdit.setDescription(instantDto.getDescription());
        instantToEdit.setImgUrl(instantDto.getImgUrl());
        instantToEdit.setLocation(instantDto.getLocation());
        return instantRepository.save(instantToEdit);
    }

    @Override
    public Instant delete(Long id) {
        var instantToDelete = instantRepository.findById(id).get();
        this.instantRepository.delete(instantToDelete);
        return instantToDelete;
    }

    @Override
    public List<Instant> findBySearch(String search) {
        var searchList = instantRepository.findByTitleContainsOrDescriptionContainsOrLocationContainsAllIgnoreCase(search);
        return searchList;
    }

}
