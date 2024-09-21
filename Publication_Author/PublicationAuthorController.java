package com.example.demo.Publication_Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/publication-author")
public class PublicationAuthorController {

    @Autowired
    private PublicationAuthorService publicationAuthorService;

    @GetMapping
    public List<PublicationAuthor> getAllPublicationAuthors() {
        return publicationAuthorService.getAllPublicationAuthors();
    }
}