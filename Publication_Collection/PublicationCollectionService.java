package com.example.demo.Publication_Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PublicationCollectionService {

    @Autowired
    private PublicationCollectionRepository publicationCollectionRepository;

    public List<PublicationCollection> getAllPublicationCollection() {
        return publicationCollectionRepository.findAll();
    }
}