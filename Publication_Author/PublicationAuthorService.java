package com.example.demo.Publication_Author;

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
}
