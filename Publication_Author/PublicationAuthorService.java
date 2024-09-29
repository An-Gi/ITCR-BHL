package com.example.demo.Publication_Author;

import com.example.demo.Author.Author;
import com.example.demo.Publication.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PublicationAuthorService {

    @Autowired
    private PublicationAuthorRepository publicationAuthorRepository;

    /* Método para encontrar un autor por su id, recibe un objeto de
    tipo "Publication" y devuelve una lista de objetos de tipo
    "PublicationAuthor".*/
    public List<PublicationAuthor> authorByPublication(Publication publication){
        return publicationAuthorRepository.findByPublication(publication);
    }

    /* Método para agregar una nueva relación "PublicationAuthor",
    recibe dos objetosuno de tipo "Publication" y el otro de tipo "Author".
    No devuelve nada. */
    public void addNewPublicationAuthor(Publication publication, Author author){
        PublicationAuthor publicationAuthor = new PublicationAuthor();
        publicationAuthor.setAuthor(author);
        publicationAuthor.setPublication(publication);
        publicationAuthorRepository.save(publicationAuthor);
    }

    /* Método para eliminar una relación "PublicationAuthor", recibe
    un objeto de tipo "Publicaion" y no devuelve nada.*/

    public void deletePublicationAuthor(Publication publication){
        publicationAuthorRepository.deleteByPublication(publication);
    }
}
