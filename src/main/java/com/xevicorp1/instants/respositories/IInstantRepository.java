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
            "where i.title like concat('%', :title, '%') or i.description like concat('%', :description, '%')")
    List<Instant> findByTitleContainsOrDescriptionContains(@Param("title") String title, @Param("description") String description);

}
