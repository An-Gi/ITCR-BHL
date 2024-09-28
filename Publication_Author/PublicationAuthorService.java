package com.example.demo.Publication_Author;

import com.example.demo.Author.Author;
import com.example.demo.Author.AuthorRepository;
import com.example.demo.Collection.Collection;
import com.example.demo.Publication.Publication;
import com.example.demo.Publication_Collection.PublicationCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PublicationAuthorService {

    @Autowired
    private PublicationAuthorRepository publicationAuthorRepository;


    public List<PublicationAuthor> getAllPublicationAuthors() {
        return publicationAuthorRepository.findAll();
    }

    public List<PublicationAuthor> authorById(Publication publication){
        return publicationAuthorRepository.findByPublication(publication);
    }

    public void addNewPublicationAuthor(Publication publication, Author author){
        PublicationAuthor publicationAuthor = new PublicationAuthor();
        publicationAuthor.setAuthor(author);
        publicationAuthor.setPublication(publication);
        publicationAuthorRepository.save(publicationAuthor);
    }

    public void deletePublicationAuthor(Publication publication){
        publicationAuthorRepository.deleteByPublication(publication);
    }
}
