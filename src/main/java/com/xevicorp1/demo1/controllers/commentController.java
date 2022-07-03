package com.xevicorp1.demo1.controllers;

import com.xevicorp1.demo1.dtos.CommentRequestDto;
import com.xevicorp1.demo1.models.Comment;
import com.xevicorp1.demo1.repositories.ICommentRepository;
import com.xevicorp1.demo1.repositories.IItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class commentController {
    private ICommentRepository commentRepository;
    private IItemRepository itemRepository;

    public commentController(ICommentRepository commentRepository, IItemRepository itemRepository) {
        this.commentRepository = commentRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/comments")
    List<Comment> getAll(){
        return this.commentRepository.findAll();
    }

    //Enlloc d'un comment(controller) li diem que volem rebre un commentRequestDto
    //Posem les dades del comment del Dto al comment real (controller)
    //Quan arriba un "opcional" hi posem un .get() final.
    @PostMapping("/comments")
    Comment create(@RequestBody CommentRequestDto commentDto){
        var newComment = new Comment();
        newComment.setComment(commentDto.getComment());
        var item = this.itemRepository.findById(commentDto.getItemId()).get();
        newComment.setItem(item);
        return this.commentRepository.save(newComment);
    }
}
