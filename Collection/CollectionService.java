package com.example.demo.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    /* Método para obtener todas las colecciones, no recibe
    nada como parámetros y devuelve una lista de objetos de
    tipo "Collection" */
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

    /* Método para obtener una colección por el nombre, recibe
    un string que representa el nombre y devuelve un objeto de
     tipo "Collection" si es que se encuentra.*/
    public Optional<Collection> getCollectionByName(String name){
        return collectionRepository.findCollectionByName(name);
    }
}