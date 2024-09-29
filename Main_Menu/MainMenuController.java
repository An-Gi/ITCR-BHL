package com.example.demo.Main_Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controlador para el menú principal.
@Controller
public class MainMenuController {
    @GetMapping("/Menu")
    public String showMainMenu() {
        return "MainMenu";
    }

}
