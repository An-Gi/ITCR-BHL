package com.example.demo.Publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publications")
public class ShowPublication {

    @Autowired
    private PublicationService publicationService;

    @GetMapping("/showAll")
    public String getAllPublications(@RequestParam(value = "query", required = false, defaultValue = "") String query, Model model) {
        if(!query.isEmpty()){
            publicationService.deletePublication(Integer.valueOf(query));
        }
        model.addAttribute("Publications", publicationService.getAllPublications());
        return "allPublications";
        //return "InsertData";
    }


    @GetMapping("/byTitle")
    public String getPublicationsByTitle(@RequestParam("query") String query, Model model) {
        model.addAttribute("Publications", publicationService.getByTitle(query));
        return "PublicationSearch";
    }
}