package com.example.demo.Collection;

import com.example.demo.Publication_Collection.PublicationCollection;
import com.example.demo.Publication_Collection.PublicationCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /* Método para mostrar las colecciones, recibe un
     objeto de tipo "Model" y devuelve un string */
    @GetMapping
    public String showCollections(Model model) {
        List<Collection> collections = collectionService.getAllCollections();
        model.addAttribute("Collection", collections); // Aquí pasamos la lista al modelo
        return "Collections"; // Nombre del HTML
    }


}