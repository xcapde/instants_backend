package com.xevicorp1.demo1.repositories;

import com.xevicorp1.demo1.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
