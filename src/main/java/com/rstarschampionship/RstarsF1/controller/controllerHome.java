package com.rstarschampionship.RstarsF1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controllerHome {

    @RequestMapping(value = "/")
    public String Home() {


        return "home";
    }
}
