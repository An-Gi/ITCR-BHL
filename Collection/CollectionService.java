package com.example.demo.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    /*public Collection getCollectionById(Long id){
        Optional<Collection> collectionOpt = collectionRepository.findById(id);
        return collectionOpt.orElse(null);
    }*/

    public Optional<Collection> getCollectionById(Long id){
        return collectionRepository.findById(id);
    }
}