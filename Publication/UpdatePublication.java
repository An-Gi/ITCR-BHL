package com.example.demo.Publication;

import com.example.demo.Author.Author;
import com.example.demo.Author.AuthorService;
import com.example.demo.Collection.Collection;
import com.example.demo.Collection.CollectionService;
import com.example.demo.Institution.Institution;
import com.example.demo.Institution.InstitutionService;
import com.example.demo.Publication_Author.PublicationAuthor;
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
@RequestMapping("/updatePublication")
public class UpdatePublication {

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

    @GetMapping
    public String requestData(@RequestParam(value = "query", required = false, defaultValue = "") String query, Model model){
        Publication publication = publicationService.getByID(Integer.parseInt(query));
        model.addAttribute("Publicacion", publication);
        model.addAttribute("Autores", publicationAuthorService.authorById(publication));
        model.addAttribute("Collections", publicationCollectionService.collectionByID(publication));
        model.addAttribute("Species", publicationSpeciesService.speciesByPublication(publication));
        return "Updating";
    }

    @Transactional
    @PostMapping("/publicationUpdated")
    public String registerUser(@RequestParam("publicationId") int id,
                               @RequestParam("title") String title,
                               @RequestParam("authors") List<String> authorsList,
                               @RequestParam("publicationdate") String publicationdate,
                               @RequestParam("species") List<String> speciesList,
                               @RequestParam("publisher") String publisher,
                               @RequestParam("doi") String doi,
                               @RequestParam("isbn") String isbn,
                               @RequestParam("country") String country,
                               @RequestParam("institution") int institution,
                               @RequestParam("collections") List<String> collectionsList, Model publicaciones){
        // Lógica para actualizar la publicación
        Publication publication = publicationService.getByID(id);
        if (!title.isEmpty()) publication.setTitle(title);
        if (!authorsList.isEmpty()) {
            publicationAuthorService.deletePublicationAuthor(publication);
            for (String authorsID : authorsList) {
                if(!authorsID.isEmpty()) {
                    Author author = authorService.getAuthorByIdCard(Integer.parseInt(authorsID)).get();
                    publicationAuthorService.addNewPublicationAuthor(publication, author);
                }
            }
        }
        if(!publicationdate.isEmpty()) publication.setPostdate(LocalDate.parse(publicationdate));
        if (!speciesList.isEmpty()) {
            publicationSpeciesService.deletePublicationSpecies(publication);
            for (String speciesName : speciesList) {
                if(!speciesName.isEmpty()) {
                    Species species = speciesService.findByName(speciesName).getFirst();
                    publicationSpeciesService.addNewPublicationSpecies(publication, species);
                }
            }
        }
        if(!publisher.isEmpty()) publication.setPublisherMagazine(publisher);
        if(!doi.isEmpty()) publication.setDoi(doi);
        if(!isbn.isEmpty()) publication.setIsbn(isbn);
        if(!country.isEmpty()) publication.setPublicationcountry(country);
        if(institution != 0) publication.setInstitution(institutionService.getByID(institution).get());
        if (!collectionsList.isEmpty()) {
            publicationCollectionService.deletePublicationCollection(publication);
            for (String collectionsName : collectionsList) {
                if(!collectionsName.isEmpty()) {
                    Collection collection = collectionService.getCollectionByName(collectionsName).get();
                    publicationCollectionService.addNewPublicationCollection(publication, collection);
                }
            }
        }
        publicaciones.addAttribute("Publications", publicationService.getAllPublications());
        return "allPublications";
    }
}
