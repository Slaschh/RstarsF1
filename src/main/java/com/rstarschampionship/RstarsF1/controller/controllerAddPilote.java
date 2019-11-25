package com.rstarschampionship.RstarsF1.controller;


import com.rstarschampionship.RstarsF1.entity.Pilote;
import com.rstarschampionship.RstarsF1.services.PiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class controllerAddPilote {

    private final PiloteService piloteService;

    @Autowired
    public controllerAddPilote(PiloteService piloteService) {
        this.piloteService = piloteService;
    }

    @RequestMapping(value = "/addPilote", method = RequestMethod.GET)
    public String AddPilote(Model model) {
        Pilote addpilote = new Pilote();
        addpilote.setIntegration(new Date());
        model.addAttribute("pilote", addpilote);
        model.addAttribute("pageTitle", "Ajout Pilote");
        return "addPilote";
    }

    @RequestMapping(value = "/addPilote", method = RequestMethod.POST)
    public String AddPilote(@ModelAttribute Pilote pilote, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pilote", pilote);
            System.out.println(pilote);
            return "addPilote";
        }

        System.out.println(pilote);
        piloteService.save(pilote);

        return "home";
    }
}
