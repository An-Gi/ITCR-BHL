package com.example.demo.publication;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/allPublications")
public class ShowPublication {

    @Autowired
    private PublicationService publicationService;

    @GetMapping
    public String getAllPublications(Model model) {
        model.addAttribute("Publications", publicationService.getAllPublications());
        return "allPublications";
    }

}