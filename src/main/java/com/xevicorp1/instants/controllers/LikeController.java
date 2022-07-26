package com.xevicorp1.instants.controllers;

import com.xevicorp1.instants.dto.CommentRequestDto;
import com.xevicorp1.instants.dto.LikeRequestDto;
import com.xevicorp1.instants.models.Comment;
import com.xevicorp1.instants.models.Like;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.IUserRepository;
import com.xevicorp1.instants.services.ILikeService;
import com.xevicorp1.instants.services.IUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LikeController {
    private ILikeService likeService;
    private IUserService userService;

//
//    @PostMapping("/likes")
//    Like like(@RequestBody LikeRequestDto likeRequest){
//        var authUser = getAuthUser();
//        return likeService.create(likeRequest, authUser);
//    }
//
//    private User getAuthUser() {
//        return userService.getById(1L);
//    }

}
