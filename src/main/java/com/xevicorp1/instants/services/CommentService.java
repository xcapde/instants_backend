package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.CommentRequestDto;
import com.xevicorp1.instants.models.Comment;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.ICommentRepository;
import com.xevicorp1.instants.respositories.IInstantRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CommentService implements ICommentService{
    private ICommentRepository commentRepository;
    private IInstantRepository instantRepository;

    public CommentService(ICommentRepository commentRepository, IInstantRepository instantRepository) {
        this.commentRepository = commentRepository;
        this.instantRepository = instantRepository;
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(Long id) {
        var comment = commentRepository.findById(id).get();
        return comment;
    }

//    @Override
//    public List<Comment> getAllByInstantId(Long id) {
//        var commentedInstant = instantRepository.findById(id).get();
//        var commentedId = commentedInstant.getId();
//        var commentsListById = commentedInstant.getComments();
////        return commentRepository.findAllById(Collections.singleton(commentedId));
//        return commentRepository.findAll();
//    }

    @Override
    public Comment create(CommentRequestDto commentDto, User auth) {
        var comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setCreator(auth);
        var instant = instantRepository.findById(commentDto.getInstantId()).get();
        comment.setInstant(instant);
        return commentRepository.save(comment);
    }
}
