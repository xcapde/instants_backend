package com.xevicorp1.instants.controllers;

import com.xevicorp1.instants.dto.CommentRequestDto;
import com.xevicorp1.instants.models.Comment;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.services.ICommentService;
import com.xevicorp1.instants.services.IInstantService;
import com.xevicorp1.instants.services.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
    private ICommentService commentService;
    private IUserService userService;

    public CommentController(ICommentService commentService, IUserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/comments")
    List<Comment> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/comments/{id}")
    Comment findById(@PathVariable Long id){
        return commentService.getById(id);
    }

//    @GetMapping("/instants/{id}/comments")
//    List<Comment> getAllByInstantId(@PathVariable Long id){
//        return commentService.getAllByInstantId(id);
//    }

    @PostMapping("/comments")
    Comment create(@RequestBody CommentRequestDto commentRequest){
        var authUser = getAuthUser();
        return commentService.create(commentRequest, authUser);
    }
    private User getAuthUser(){
        return userService.getById(1L);
    }

}
