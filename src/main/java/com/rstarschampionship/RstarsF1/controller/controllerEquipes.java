package com.rstarschampionship.RstarsF1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controllerEquipes {

    @RequestMapping(value = "/ecuries")
    public String ecuries ()
    {


        return "ecuries";
    }
}
