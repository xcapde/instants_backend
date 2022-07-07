package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.InstantRequestDto;
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

    @Override
    public Instant create(InstantRequestDto instantDto, User auth) {
        var instant = new Instant();
        instant.setTitle(instantDto.getTitle());
        instant.setDescription(instantDto.getDescription());
        instant.setImage(instantDto.getImage());
        instant.setLocation(instantDto.getLocation());
        instant.setCreator(auth);
        return instantRepository.save(instant);
    }
}
