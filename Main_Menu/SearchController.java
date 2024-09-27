package com.example.demo.Main_Menu;


import com.example.demo.Publication_Author.PublicationAuthorService;
import com.example.demo.Publication_Collection.PublicationCollectionService;
import com.example.demo.Publication_Species.PublicationSpeciesService;
import com.example.demo.Publication.Publication;
import com.example.demo.Publication.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SearchController {
    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationAuthorService publicationAuthorService;

    @Autowired
    private PublicationCollectionService publicationCollectionService;

    @Autowired
    private PublicationSpeciesService publicationSpeciesService;
    @GetMapping("/publication/{idPost}")
    public String search(@PathVariable("idPost") Integer id, Model model) {
        Publication publication = publicationService.getByID(id);
        model.addAttribute("Publicacion", publication);
        model.addAttribute("Autores", publicationAuthorService.authorById(publication));
        model.addAttribute("Collections", publicationCollectionService.collectionByID(publication));
        model.addAttribute("Species", publicationSpeciesService.speciesByPublication(publication));
        return "Publication";
    }
}
