package com.xevicorp1.instants.controllers;

import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.services.IInstantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class InstantController {
    private IInstantService instantService;

    public InstantController(IInstantService instantService) {
        this.instantService = instantService;
    }

    @GetMapping("/instants")
    List<Instant> getAll(){
        return instantService.getAll();
    }
}
