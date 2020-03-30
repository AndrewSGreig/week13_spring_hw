package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Raids;
import com.example.codeclan.pirateservice.repositories.RaidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/raids")
public class RaidsController {

    @Autowired
    RaidsRepository raidsRepository;

    @GetMapping
    public List<Raids> getAllRaids() {
        return raidsRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Raids> getRaid(@PathVariable Long id) {
        return raidsRepository.findById(id);
    }

}
