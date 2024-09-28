package com.example.demo.Publication_Collection;

import com.example.demo.Collection.Collection;
import com.example.demo.Publication.Publication;
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

    public List<PublicationCollection> publiByID(Collection collection){
        return publicationCollectionRepository.findByCollection(collection);
    }

    public List<PublicationCollection>collectionByID(Publication publication){
        return publicationCollectionRepository.findByPublication(publication);
    }

    public void addNewPublicationCollection(Publication publication, Collection collection){
        PublicationCollection publicationCollection = new PublicationCollection();
        publicationCollection.setCollection(collection);
        publicationCollection.setPublication(publication);
        publicationCollectionRepository.save(publicationCollection);
    }

    public void deletePublicationCollection(Publication publication){
        publicationCollectionRepository.deleteByPublication(publication);
    }
}