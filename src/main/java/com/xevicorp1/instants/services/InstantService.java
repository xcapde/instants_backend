package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.IInstantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Instant getById(Long id) {
//        var instantList = instantRepository.findAll();
//        var instant = instantList.stream().filter(i -> i.getId() == id).findFirst().get();
        var instant = instantRepository.findById(id).get();
        return instant;
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
    public List<Instant> findByTitleContainsOrDescriptionContains(String text) {
        var instantsList = this.getAll();
        var searchList = instantsList.stream()
                .filter( i -> i.getTitle().contains(text) || i.getDescription().contains(text))
                .collect(Collectors.toList());
        return searchList;
    }
}
