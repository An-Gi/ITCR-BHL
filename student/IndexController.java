package com.example.demo.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("inicio")
public class IndexController {
    @GetMapping
    public String inicio() {
        return "index"; // Devuelve el nombre del archivo HTML desde src/main/resources/templates
    }
}