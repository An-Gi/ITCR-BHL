package com.example.demo.Publication_Collection;

import com.example.demo.Collection.Collection;
import com.example.demo.Collection.CollectionRepository;
import com.example.demo.publication.Publication;
import com.example.demo.student.Student;
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


}