package com.rstarschampionship.RstarsF1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controllerClassement {

    @RequestMapping
    public String Classement(Model model)
    {

        return "classement";
    }
}
