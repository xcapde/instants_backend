package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.CommentRequestDto;
import com.xevicorp1.instants.models.Comment;
import com.xevicorp1.instants.models.User;

import java.util.List;

public interface ICommentService {

    List<Comment>getAll();

    Comment create(CommentRequestDto commentDto, User auth);
}
