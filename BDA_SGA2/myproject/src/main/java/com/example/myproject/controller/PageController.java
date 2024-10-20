package com.example.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/showbooks")
    public String showbooks() {
        return "showbooks";
    }

    @GetMapping("/modifybooks")
    public String modifybooks() {
        return "modifybooks";
    }

    @GetMapping("/showauthors")
    public String showauthors() {
        return "showauthors";
    }

    @GetMapping("/modifyauthors")
    public String modifyauthors() {
        return "modifyauthors";
    }

    @GetMapping("/showbooksandauthors")
    public String showbooksandauthors() {
        return "showbooksandauthors";
    }
 
}
