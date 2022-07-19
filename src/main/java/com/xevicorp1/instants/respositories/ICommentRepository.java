package com.xevicorp1.instants.respositories;

import com.xevicorp1.instants.models.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.instant.id = :id")
    List<Comment> findCommentsByInstantId(@Param("id") Long id);

}
