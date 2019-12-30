package com.rstarschampionship.RstarsF1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controllerHome {

    @RequestMapping(value = "/")
    public String Home(Model model) {
        model.addAttribute("pageTitle", "Home Page");

        return "home";
    } 
}
