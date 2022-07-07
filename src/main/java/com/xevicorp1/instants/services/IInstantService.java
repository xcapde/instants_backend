package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;

import java.util.List;

public interface IInstantService {

    List<Instant> getAll();

    Instant create(InstantRequestDto instantRequestDto, User auth);

}
