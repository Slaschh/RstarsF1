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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller

public class controllerAddPilote {

    @Autowired
    private PiloteService piloteService;


    @RequestMapping(value = "/addPilote", method = RequestMethod.GET)
    public String AddPilote(Model model, HttpServletRequest request) {
        Pilote addpilote = new Pilote();
        addpilote.setIntegration(new Date());
        model.addAttribute("pilote", addpilote);
        model.addAttribute("listPilote", piloteService.findAll());
        model.addAttribute("pageTitle", "Ajout Pilote");
        request.isUserInRole("someAuthority");
        return "addPilote";
    }

    @RequestMapping(value = "/addPilote", method = RequestMethod.POST)
    public String AddPilote(@ModelAttribute Pilote pilote, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pilote", pilote);
            System.out.println(pilote);

            return "addPilote";
        }

        model.addAttribute("listPilote", piloteService.findAll());
        System.out.println(pilote);
        piloteService.save(pilote);


        return "home";
    }
}
