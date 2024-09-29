package com.example.demo.Publication_Species;

import com.example.demo.Species.Species;
import com.example.demo.Publication.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PublicationSpeciesService {

    @Autowired
    private PublicationSpeciesRepository publicationSpeciesRepository;

    /* Método para buscar por especie, recibe un objeto de tipo "Species"
      y devuelve una lista de objetos de tipo "PublicationSpecies".*/
    public List<PublicationSpecies> getPublicationBySpecies(Species species){
        return publicationSpeciesRepository.findBySpecies(species);
    }

    /* Método para buscar por publicación, recibe un objeto de tipo "Publication"
     y devuelve una lista de objetos de tipo "PublicationSpecies".*/
    public List<PublicationSpecies> speciesByPublication(Publication publication){
        return publicationSpeciesRepository.findByPublications(publication);
    }

    /* Método para añadir una nueva relación "PublicationSpecies", recibe
     dos objetos uno de tipo "Species" y el otro "Publication" y no devuelve
     nada".*/
    public void addNewPublicationSpecies(Publication publication, Species species){
        PublicationSpecies publicationSpecies = new PublicationSpecies();
        publicationSpecies.setSpecies(species);
        publicationSpecies.setPublication(publication);
        publicationSpeciesRepository.save(publicationSpecies);
    }

    /* Método para eliminar una relación "PublicationSpecies", recibe
   un objeto de tipo "Publicaion" y no devuelve nada.*/
    public void deletePublicationSpecies(Publication publication){
        publicationSpeciesRepository.deleteByPublication(publication);
    }
}