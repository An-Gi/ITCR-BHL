package com.example.demo.Publication;

import com.example.demo.Author.Author;
import com.example.demo.Author.AuthorService;
import com.example.demo.Collection.Collection;
import com.example.demo.Collection.CollectionService;
import com.example.demo.Institution.Institution;
import com.example.demo.Institution.InstitutionService;
import com.example.demo.Publication_Author.PublicationAuthorService;
import com.example.demo.Publication_Collection.PublicationCollectionService;
import com.example.demo.Publication_Species.PublicationSpeciesService;
import com.example.demo.Species.Species;
import com.example.demo.Species.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterPublication {

    @Autowired
    PublicationService publicationService;
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
    @Autowired
    private ShowPublication showPublication;

    @GetMapping("/addData")
    public String requestData(){
        return "InsertData";
    }
    @PostMapping("/publication")
    public String registerUser(@RequestParam("title") String title,
                               @RequestParam("authors") List<String> authors,
                               @RequestParam("publicationdate") String publicationdate,
                               @RequestParam("species") List<String> species,
                               @RequestParam("publisher") String publisher,
                               @RequestParam("doi") String doi,
                               @RequestParam("isbn") String isbn,
                               @RequestParam("country") String country,
                               @RequestParam("institution") int institution,
                               @RequestParam("collections") List<String> collections, Model publicaciones){
        // Lógica para almacenar la publicación
        Institution asociateInstitution = institutionService.getByID(institution).get();
        Publication newPublication = new Publication(title, publicationdate, publisher, doi, isbn, country, asociateInstitution);
        publicationService.addNewPublication(newPublication);
        for(String collectionName : collections){
            Collection collection = collectionService.getCollectionByName(collectionName).get();
            publicationCollectionService.addNewPublicationCollection(newPublication, collection);
        }
        for(String authorsID : authors){
            Author author = authorService.getAuthorByID(Integer.parseInt(authorsID)).get();
            publicationAuthorService.addNewPublicationAuthor(newPublication, author);
        }
        for(String speciesName : species){
            Species speciesN = speciesService.findByName(speciesName).getFirst();
            publicationSpeciesService.addNewPublicationSpecies(newPublication, speciesN);
        }
        publicaciones.addAttribute("Publications", publicationService.getAllPublications());
        return "allPublications";
    }
}