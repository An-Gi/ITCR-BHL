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

    /* Método para buscar por colección, recibe un objeto de tipo "Collection"
      y devuelve una lista de objetos de tipo "PublicationCollection".*/
    public List<PublicationCollection> publicationByCollection(Collection collection){
        return publicationCollectionRepository.findByCollection(collection);
    }

    /* Método para buscar por publicación, recibe un objeto de tipo "Publication"
      y devuelve una lista de objetos de tipo "PublicationCollection".*/
    public List<PublicationCollection>collectionByPublication(Publication publication){
        return publicationCollectionRepository.findByPublication(publication);
    }

    /* Método para añadir una nueva relación "PublicationCollection",  recibe
     dos objetos uno de tipo "Collection" y el otro "Publication" y no devuelve
     nada".*/
    public void addNewPublicationCollection(Publication publication, Collection collection){
        PublicationCollection publicationCollection = new PublicationCollection();
        publicationCollection.setCollection(collection);
        publicationCollection.setPublication(publication);
        publicationCollectionRepository.save(publicationCollection);
    }

    /* Método para eliminar una relación "PublicationCollection", recibe
   un objeto de tipo "Publicaion" y no devuelve nada.*/
    public void deletePublicationCollection(Publication publication){
        publicationCollectionRepository.deleteByPublication(publication);
    }
}