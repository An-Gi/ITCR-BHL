package com.example.demo.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class ShowCollection {

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private CollectionRepository collectionRepository;

    @GetMapping("/ShowCollections")
    public String showCollections(Model model) {
        List<Collection> collections = collectionService.getAllCollections();
        model.addAttribute("Collection", collections); // Aquí pasamos la lista al modelo
        return "Collections"; // Nombre de la plantilla HTML (collections.html)
    }

    /*@GetMapping("/Collection/{id}")
    public String searchCollection(@PathVariable("id") Long id, Model model) {
        Collection collectionById = collectionService.getCollectionById(id);
        model.addAttribute("Publication", collectionById);
        return "PublicationsCollection";  // La vista que renderiza los datos
    }*/

}