package com.example.demo.Publication_Collection;

import com.example.demo.Collection.Collection;
import com.example.demo.Collection.CollectionService;
import com.example.demo.Publication_Author.PublicationAuthor;
import com.example.demo.Publication_Author.PublicationAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/publication-collection")
public class PublicationCollectionController {

    @Autowired
    private PublicationCollectionService publicationCollectionService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private PublicationAuthorService publicationAuthorService;

    @GetMapping
    public List<PublicationCollection> getAllPublicationCollection() {
        return publicationCollectionService.getAllPublicationCollection();
    }



    @GetMapping("/{id}")
    public String showById(@PathVariable("id") Long id, Model conjuntoDatos){
        Collection collection = collectionService.getCollectionById(id).get();
        List<PublicationCollection> publicaciones = publicationCollectionService.publiByID(collection);
        conjuntoDatos.addAttribute("PublicationCollection", publicaciones);

        // Crear un mapa para almacenar los autores por cada publicación
        Map<Integer, List<PublicationAuthor>> autoresMap = new HashMap<>();

        Map<Integer, List<PublicationCollection>> collectionMap = new HashMap<>();


        for (PublicationCollection pubCol : publicaciones) {
            List<PublicationAuthor> autores = publicationAuthorService.authorById(pubCol.getPublication());
            autoresMap.put(pubCol.getPublication().getIdPost(), autores);
            List<PublicationCollection> collections = publicationCollectionService.collectionByID(pubCol.getPublication());
            collectionMap.put(pubCol.getPublication().getIdPost(), collections);
        }

        conjuntoDatos.addAttribute("AutoresMap", autoresMap);

        conjuntoDatos.addAttribute("ColletionMap", collectionMap);

        return "PublicationsCollection";
    }


}
