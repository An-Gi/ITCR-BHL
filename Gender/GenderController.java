package com.example.demo.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping
    public List<Gender> getAllGenders() {
        return genderService.getAllGenders();
    }
}
