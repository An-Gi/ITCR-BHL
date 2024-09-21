package com.example.demo.Main_Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search")  // Maneja solicitudes GET en la ruta "/search"
    public String search(@RequestParam("query") String query) {
        // Aquí recibes el parámetro "query" desde el formulario de búsqueda
        System.out.println("Valor de búsqueda: " + query); // Para visualizar el valor en consola
        // Retorna la vista donde mostrarás los resultados (puede ser "result.html")
        return "index";  // Busca la vista "result.html" en la carpeta de plantillas
    }
}
