package com.example.demo.Main_Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

    @GetMapping("/")
    public String showMainMenu() {
        return "MainMenu"; // Esto buscará un archivo llamado "index.html" en el directorio templates
    }
}
