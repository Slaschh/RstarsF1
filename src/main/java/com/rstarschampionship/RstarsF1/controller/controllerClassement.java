package com.rstarschampionship.RstarsF1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static com.rstarschampionship.RstarsF1.entity.Classement.classement;


@Controller

public class controllerClassement {

    @RequestMapping(value = "/classement", method = RequestMethod.GET)
    public String classementList (Model model)
    {

        model.addAttribute("Classement", classement);

        return "classement";
    }

}

