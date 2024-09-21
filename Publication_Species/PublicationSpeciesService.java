package com.example.demo.Publication_Species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PublicationSpeciesService {

    @Autowired
    private PublicationSpeciesRepository publicationSpeciesRepository;

    public List<PublicationSpecies> getAllPublicationSpecies() {
        return publicationSpeciesRepository.findAll();
    }


}