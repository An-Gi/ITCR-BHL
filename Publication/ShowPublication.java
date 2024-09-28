package com.example.demo.Publication;

import com.example.demo.Author.AuthorService;
import com.example.demo.Collection.CollectionService;
import com.example.demo.Institution.InstitutionService;
import com.example.demo.Publication_Author.PublicationAuthorService;
import com.example.demo.Publication_Collection.PublicationCollectionService;
import com.example.demo.Publication_Species.PublicationSpeciesService;
import com.example.demo.Species.SpeciesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publications")
public class ShowPublication {

    @Autowired
    private PublicationService publicationService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private PublicationCollectionService publicationCollectionService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublicationAuthorService publicationAuthorService;
    @Autowired
    private SpeciesService speciesService;
    @Autowired
    private PublicationSpeciesService publicationSpeciesService;
    @Autowired
    private InstitutionService institutionService;
    @GetMapping("/showAll")
    public String getAllPublications(Model model) {
        model.addAttribute("Publications", publicationService.getAllPublications());
        return "allPublications";
    }

    @Transactional
    @GetMapping("/deleted")
    public String publicationDeleted(@RequestParam(value = "query", required = false, defaultValue = "") String query) {
        if(!query.isEmpty()){
            Publication publication = publicationService.getByID(Integer.parseInt(query));
            publicationAuthorService.deletePublicationAuthor(publication);
            publicationCollectionService.deletePublicationCollection(publication);
            publicationSpeciesService.deletePublicationSpecies(publication);
            publicationService.deletePublication(Integer.valueOf(query));
        }
        return "PublicationDeleted";
    }


    @GetMapping("/byTitle")
    public String getPublicationsByTitle(@RequestParam("query") String query, Model model) {
        model.addAttribute("Publications", publicationService.getByTitle(query));
        return "PublicationSearch";
    }
    @GetMapping("/{idPost}")
    public String search(@PathVariable("idPost") Integer id, Model model) {
        Publication publication = publicationService.getByID(id);
        model.addAttribute("Publicacion", publication);
        model.addAttribute("Autores", publicationAuthorService.authorById(publication));
        model.addAttribute("Collections", publicationCollectionService.collectionByID(publication));
        model.addAttribute("Species", publicationSpeciesService.speciesByPublication(publication));
        return "Publication";
    }
}