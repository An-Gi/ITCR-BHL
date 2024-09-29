package com.example.demo.Publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;
    /* Método para obtener todas las publicaciones, no recibe ningún
    parámetro y devuelve una lista de objetos de tipo "Publication".
     */
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    /* Método para agregar una nueva publicación, recibe un objeto de
     tipo "Publication" y no devuelve nada. */
    public void addNewPublication(Publication publication){
        Optional<Publication> PublicationByDoi = publicationRepository.findPublicationByDoi(publication.getDoi());
        if (PublicationByDoi.isPresent()){
            throw new IllegalStateException("La publicación ya se encuentra en la base de datos");
        }
        publicationRepository.save(publication);
    }

    /* Método para eliminar una publicación por su id, recibe un int que
    representa el id y no devuelve nada. */
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

    public Publication getByID(int id){
        return publicationRepository.findById(id).get();
    }

    /* Método para obtener una publicacion por su título , recibe un string
    que representa el título y devuelve una lista de objetos de tipo
    "Publication". */
    public List<Publication> getByTitle(String title){
        return publicationRepository.findByTitleLike(title);
    }

}