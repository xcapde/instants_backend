package com.xevicorp1.items.repositories;

import com.xevicorp1.items.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
