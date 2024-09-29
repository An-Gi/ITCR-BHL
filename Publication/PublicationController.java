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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/publications")
public class PublicationController {

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

    /* Método para redirigir al usuario si desea agregar
    una publicación, no recibe ningún parámetro y devuelve
    un String */
    @GetMapping("/addingData")
    public String requestData(){
        return "InsertData";
    }

    /* Método para agregar una publicación, recibe como
     parámetros la información relacionada una publicación
     y devuelve un String*/
    @PostMapping("/publicationAdded")
    public String addPublication(@RequestParam("title") String title,
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
            Author author = authorService.getAuthorByIdCard(Integer.parseInt(authorsID)).get();
            publicationAuthorService.addNewPublicationAuthor(newPublication, author);
        }
        for(String speciesName : species){
            Species speciesN = speciesService.findByName(speciesName).getFirst();
            publicationSpeciesService.addNewPublicationSpecies(newPublication, speciesN);
        }
        publicaciones.addAttribute("Publications", publicationService.getAllPublications());
        return "PublicationAdded";
    }
}
