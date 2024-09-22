package com.example.demo.Main_Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

    @GetMapping("/Menu")
    public String showMainMenu() {
        return "MainMenu";
    }

    @GetMapping("/Collections")
    public String showCollections() {
        return "Collections";
    }

    @GetMapping("/error")
    public String show404() {
        return "index";
    }

}
