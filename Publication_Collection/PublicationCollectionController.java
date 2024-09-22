package com.example.demo.Publication_Collection;

import com.example.demo.Author.Author;
import com.example.demo.Collection.Collection;
import com.example.demo.Collection.CollectionService;
import com.example.demo.publication.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/publication-collection")
public class PublicationCollectionController {

    @Autowired
    private PublicationCollectionService publicationCollectionService;

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public List<PublicationCollection> getAllPublicationCollection() {
        return publicationCollectionService.getAllPublicationCollection();
    }



    @GetMapping("/{id}")
    public String showById(@PathVariable("id") Long id, Model model){
        Collection collection = collectionService.getCollectionById(id).get();
        model.addAttribute("PublicationCollection", publicationCollectionService.publiByID(collection));
        return "PublicationsCollection";
    }


}
