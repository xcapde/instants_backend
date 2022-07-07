package com.xevicorp1.instants.controllers;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.services.IInstantService;
import com.xevicorp1.instants.services.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class InstantController {
    private IInstantService instantService;
    private IUserService userService;

    public InstantController(IInstantService instantService, IUserService userService) {
        this.instantService = instantService;
        this.userService = userService;
    }

    @GetMapping("/instants")
    List<Instant> getAll(){
        return instantService.getAll();
    }

    @GetMapping("/instants/{id}")
    Instant getByID(@PathVariable Long id){
        Instant instant = instantService.getById(id);
        return instant;
    }

    @PostMapping("/instants")
    Instant create(@RequestBody InstantRequestDto instantRequest){
        var authUser = getAuthUser();
        return instantService.create(instantRequest, authUser);
    }
    private User getAuthUser(){
        return userService.getById(1L);
    }

}
