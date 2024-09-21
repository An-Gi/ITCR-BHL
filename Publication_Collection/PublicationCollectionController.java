package com.example.demo.Publication_Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publication-collection")
public class PublicationCollectionController {

    @Autowired
    private PublicationCollectionService publicationCollectionService;

    @GetMapping
    public List<PublicationCollection> getAllPublicationCollection() {
        return publicationCollectionService.getAllPublicationCollection();
    }
}
