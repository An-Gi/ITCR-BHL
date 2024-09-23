package com.example.demo.Main_Menu;


import com.example.demo.Collection.Collection;
import com.example.demo.Collection.CollectionService;
import com.example.demo.Publication_Author.PublicationAuthor;
import com.example.demo.Publication_Author.PublicationAuthorService;
import com.example.demo.Publication_Collection.PublicationCollection;
import com.example.demo.Publication_Collection.PublicationCollectionService;
import com.example.demo.publication.Publication;
import com.example.demo.publication.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {
    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationAuthorService publicationAuthorService;

    @Autowired
    private PublicationCollectionService publicationCollectionService;
    @GetMapping("/publication/{idPost}")
    public String search(@PathVariable("idPost") Integer id, Model model) {
        Publication publication = publicationService.getByID(id);
        model.addAttribute("Publicacion", publication);
        model.addAttribute("Autores", publicationAuthorService.authorById(publication));
        model.addAttribute("Collections", publicationCollectionService.collectionByID(publication));
        return "Publication";
    }
}
