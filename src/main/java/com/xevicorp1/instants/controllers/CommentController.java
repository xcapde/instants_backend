package com.xevicorp1.instants.controllers;

import com.xevicorp1.instants.models.Comment;
import com.xevicorp1.instants.services.ICommentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
    private ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    List<Comment> getAll(){
        return commentService.getAll();
    }
}
