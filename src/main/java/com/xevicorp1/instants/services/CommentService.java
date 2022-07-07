package com.xevicorp1.instants.services;

import com.xevicorp1.instants.models.Comment;
import com.xevicorp1.instants.respositories.ICommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    private ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }
}
