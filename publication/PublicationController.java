package com.example.demo.publication;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @PostMapping
    public void newPublication(@RequestBody Publication publication){
        publicationService.addNewPublication(publication);
    }

    @DeleteMapping(path = "{idPost}")
    public void deletePublication(@PathVariable("idPost") Integer id){
        publicationService.deletePublication(id);
    }

    @PutMapping(path = "/id/{idPost}")
    public void updatePublicationCountry(@PathVariable("idPost") Integer id, @RequestParam(required = false) String publicationcountry) {
        publicationService.updatePublicationCountry(id, publicationcountry);
    }

    @PutMapping(path = "/title/{idPost}")
    public void updatePublicationTitle(@PathVariable("idPost") Integer id, @RequestParam(required = false) String Title){
        publicationService.updatePublicationTitle(id,Title);
    }
}