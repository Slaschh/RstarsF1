package com.rstarschampionship.RstarsF1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class controllerClassement {

    @RequestMapping(value = "/classement")
    public String classement() {
        return "classement";
    }
}
