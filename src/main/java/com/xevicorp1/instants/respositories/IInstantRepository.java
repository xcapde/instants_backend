package com.xevicorp1.instants.respositories;

import com.xevicorp1.instants.models.Instant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IInstantRepository extends JpaRepository<Instant, Long> {
}
