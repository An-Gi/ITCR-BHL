package com.example.demo.Publication_Author;

import com.example.demo.Collection.Collection;
import com.example.demo.Publication_Collection.PublicationCollection;
import com.example.demo.publication.Publication;
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
}
