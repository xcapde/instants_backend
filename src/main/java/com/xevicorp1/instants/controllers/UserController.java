package com.xevicorp1.instants.controllers;

import com.xevicorp1.instants.dto.UserRequestDto;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.services.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    User findById(@PathVariable Long id){
        var user = userService.getById(id);
        return user;
    }

    @PostMapping("/users")
    User create(@RequestBody UserRequestDto newUser){
        var createdUser = userService.create(newUser);
        return createdUser;
    }
}
