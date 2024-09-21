package com.example.demo.publication;

import com.example.demo.student.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }
    public void addNewPublication(Publication publication){
        Optional<Publication> PublicationByDoi = publicationRepository.findPublicationByDoi(publication.getDoi());
        if (PublicationByDoi.isPresent()){
            throw new IllegalStateException("La publicación ya se encuentra en la base de datos");
        }
        publicationRepository.save(publication);
    }

    public void deletePublication(Integer id){
        boolean existsById = publicationRepository.existsById(id);
        if(!existsById){
            throw new IllegalStateException("La publicación no se encuentra en la base de datos");
        }
        publicationRepository.deleteById(id);
    }

    @Transactional
    public void updatePublicationTitle(Integer id, String Title){
        Publication publication = publicationRepository.findById(id).orElseThrow(()->new IllegalStateException("No existe la publicación brindada."));
        publication.setTitle(Title);
    }

    @Transactional
    public void updatePublicationCountry(Integer id, String country) {
        Publication publication = publicationRepository.findById(id).orElseThrow(() -> new IllegalStateException("No existe la publicación brindada."));
        publication.setPublicationcountry(country);
        publicationRepository.save(publication); // Guardar los cambios en la base de datos
    }


}