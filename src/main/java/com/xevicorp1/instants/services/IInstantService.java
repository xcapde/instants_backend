package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInstantService {

    List<Instant> getAll();

    Instant getById(Long id);

    Instant create(InstantRequestDto instantRequestDto, User auth);

    Instant update(InstantRequestDto instantRequestDto, Long id);

    Instant delete(Long id);

    List<Instant> getBySearch(String text);

    @Query("SELECT i FROM Instant i WHERE i.title = :title || :description")
    List<Instant> findByTitleOrDescriptionContains(String text);
}
