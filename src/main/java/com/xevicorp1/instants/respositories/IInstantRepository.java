package com.xevicorp1.instants.respositories;

import com.xevicorp1.instants.models.Instant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInstantRepository extends JpaRepository<Instant, Long> {
    @Query("select i from Instant i " +
            "where upper(i.title) like upper(concat('%', :search, '%')) or upper(i.description) like upper(concat('%', :search, '%')) or upper(i.location) like upper(concat('%', :search, '%'))")
    List<Instant> findByTitleContainsOrDescriptionContainsOrLocationContainsAllIgnoreCase(@Param("search") String search);

    //Query canviada manualment perquè només ens interessa tenir un paràmetre("search" per títle, description i location.
}
