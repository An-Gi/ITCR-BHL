package com.example.demo.Publication_Species;

import com.example.demo.Species.Species;
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

    public List<PublicationSpecies> getBySpecies(Species species){
        return publicationSpeciesRepository.findBySpecies(species);
    }

}