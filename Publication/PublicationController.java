package com.example.demo.Publication;

import com.example.demo.Author.Author;
import com.example.demo.Author.AuthorService;
import com.example.demo.Collection.Collection;
import com.example.demo.Collection.CollectionService;
import com.example.demo.Common_Name.CommonName;
import com.example.demo.Common_Name.CommonNameService;
import com.example.demo.Institution.Institution;
import com.example.demo.Institution.InstitutionService;
import com.example.demo.Publication_Author.PublicationAuthorService;
import com.example.demo.Publication_Collection.PublicationCollectionService;
import com.example.demo.Publication_Species.PublicationSpecies;
import com.example.demo.Publication_Species.PublicationSpeciesService;
import com.example.demo.Species.Species;
import com.example.demo.Species.SpeciesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private CommonNameService commonNameService;
    @Autowired
    private InstitutionService institutionService;

    /* Método para mostrar todas las publicaciones.*/
    @GetMapping
    public String getAllPublications(Model model) {
        model.addAttribute("Publications", publicationService.getAllPublications());
        return "Publications";
    }

    /* Método para obtener las publicaciones por medio de su título,
    recibe un String que representa el título y un objeto de tipo "Model",
    devuelve un String. */
    @GetMapping("/byTitle")
    public String getPublicationsByTitle(@RequestParam("query") String query, Model model) {
        model.addAttribute("Publications", publicationService.getByTitle(query));
        return "PublicationByTitle";
    }

    /* Método para mostrar una publicación por su id, recibe un Integer que
    representa como el id y un objeto de tipo "Model, devuelve un String." */
    @GetMapping("/{idPost}")
    public String showPublication(@PathVariable("idPost") Integer id, Model model) {
        Publication publication = publicationService.getByID(id); //se busca una publicación con su id
        model.addAttribute("Publicacion", publication); // se pasa la info al modelo
        model.addAttribute("Autores", publicationAuthorService.authorByPublication(publication));
        model.addAttribute("Collections", publicationCollectionService.collectionByPublication(publication));
        List<CommonName> commonNameList = new ArrayList<>();
        for(PublicationSpecies species : publicationSpeciesService.speciesByPublication(publication)){
            commonNameList.add(commonNameService.getCommonNameBySpecies(species.getSpecies()));
        }
        model.addAttribute("NombresComunes", commonNameList);
        return "Publication";
    }

    /* Método para buscar publicaciones por especie, recibe un string
    que representa el nombre científico de la especie y un objeto de tipo
    "Model" y devuelve un String. */
    @GetMapping("/bySpecies")
    public  String getPublicationBySpecies(@RequestParam("query") String query, Model model) {
        Map<Species, List<PublicationSpecies>> publicationsBySpecies = new HashMap<>();
        List<Species> speciesList = speciesService.findByName(query);
        model.addAttribute("Species", speciesList);
        for(Species species : speciesList){
            publicationsBySpecies.put(species, publicationSpeciesService.getPublicationBySpecies(species));
        }
        model.addAttribute("Publicaciones", publicationsBySpecies);
        return "PublicationsBySpecies";
    }

    /* Método para redirigir al usuario si desea agregar
    una publicación, no recibe ningún parámetro y devuelve
    un String */
    @GetMapping("/addingData")
    public String requestData(){
        return "InsertingData";
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

    /* Método para eliminar una publicación, recibe un String que
     representa el id de la publicación y devuelve un String */
    @Transactional
    @GetMapping("/publicationDeleted")
    public String deletePublication(@RequestParam(value = "query", required = false, defaultValue = "") String query) {
        if(!query.isEmpty()){
            Publication publication = publicationService.getByID(Integer.parseInt(query));
            publicationAuthorService.deletePublicationAuthor(publication); // se eliminan las relaciones con las tablas intermedias
            publicationCollectionService.deletePublicationCollection(publication);
            publicationSpeciesService.deletePublicationSpecies(publication);
            publicationService.deletePublication(Integer.valueOf(query)); // se elimina la publicación
        }
        return "PublicationDeleted";
    }

    /* Método para redirigir al usuario si desea editar
    una publicación,recibe un string que
    representa el id de la publicación y un
    objeto de tipo "Model", devuelve un String. */
    @GetMapping("/updatingData")
    public String requestNewData(@RequestParam(value = "query", required = false, defaultValue = "") String query, Model model){
        Publication publication = publicationService.getByID(Integer.parseInt(query));
        model.addAttribute("Publicacion", publication);
        model.addAttribute("Autores", publicationAuthorService.authorByPublication(publication));
        model.addAttribute("Collections", publicationCollectionService.collectionByPublication(publication));
        model.addAttribute("Species", publicationSpeciesService.speciesByPublication(publication));
        return "UpdatingData";
    }

    /*  Método para actualizar la información de una publicación
    recibe la información relacionada de una publicación y un
    objeto de tipo "Model", devuelve un String.
     */
    @Transactional
    @PostMapping("/publicationUpdated")
    public String updatePublication(@RequestParam("publicationId") int id,
                                    @RequestParam("title") String title,
                                    @RequestParam("authors") List<String> authorsList,
                                    @RequestParam("publicationdate") String publicationdate,
                                    @RequestParam("species") List<String> speciesList,
                                    @RequestParam("publisher") String publisher,
                                    @RequestParam("doi") String doi,
                                    @RequestParam("isbn") String isbn,
                                    @RequestParam("country") String country,
                                    @RequestParam("institution") int institution,
                                    @RequestParam("collections") List<String> collectionsList,
                                    Model publicaciones){
        // Lógica para actualizar la publicación
        Publication publication = publicationService.getByID(id);
        if (!title.isEmpty()) publication.setTitle(title); // revisa si el campo no está vacio
        if (!authorsList.isEmpty()) {
            publicationAuthorService.deletePublicationAuthor(publication);
            for (String authorsID : authorsList) { // se recorre en los autores
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
        if(institution != 0) publication.setInstitution(institutionService.getByID(institution).get()); // se verifica que si exista institución
        if (!collectionsList.isEmpty()) {
            publicationCollectionService.deletePublicationCollection(publication);
            for (String collectionsName : collectionsList) {
                if(!collectionsName.isEmpty()) {
                    Collection collection = collectionService.getCollectionByName(collectionsName).get();
                    publicationCollectionService.addNewPublicationCollection(publication, collection);
                }
            }
        }
        publicaciones.addAttribute("Publications", publicationService.getAllPublications()); // se pasa la info al modelo
        return "PublicationUpdated";
    }
}
