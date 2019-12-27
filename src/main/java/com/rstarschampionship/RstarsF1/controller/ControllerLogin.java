package com.rstarschampionship.RstarsF1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLogin {

    @RequestMapping(value = "/login")
    public String login (Model model){
        model.addAttribute("pageTitle", "Login Page");

        return "login";
    }

}
