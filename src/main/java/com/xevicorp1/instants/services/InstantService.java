package com.xevicorp1.instants.services;

import com.xevicorp1.instants.models.Instant;
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
}
