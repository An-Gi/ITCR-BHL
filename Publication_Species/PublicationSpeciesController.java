package com.example.demo.Publication_Species;

import com.example.demo.Species.Species;
import com.example.demo.Species.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/publication-species")
public class PublicationSpeciesController {

    @Autowired
    private PublicationSpeciesService publicationSpeciesService;

    @Autowired
    private SpeciesService speciesService;

    @GetMapping
    public List<PublicationSpecies> getAllPublicationSpecies() {
        return publicationSpeciesService.getAllPublicationSpecies();
    }

    @GetMapping("/search")
    public  String getPublicationBySpecies(@RequestParam("query") String query, Model model) {
        Species species = speciesService.findByName(query).getFirst();
        model.addAttribute("publicaciones", publicationSpeciesService.getBySpecies(species));
        return "PublicationSpecies";
    }

}
