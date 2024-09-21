package com.example.demo.Publication_Species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publication-species")
public class PublicationSpeciesController {

    @Autowired
    private PublicationSpeciesService publicationSpeciesService;

    @GetMapping
    public List<PublicationSpecies> getAllPublicationCollection() {
        return publicationSpeciesService.getAllPublicationSpecies();
    }
}
