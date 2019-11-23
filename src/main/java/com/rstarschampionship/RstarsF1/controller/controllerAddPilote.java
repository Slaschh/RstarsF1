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
        model.addAttribute("pilote", addpilote);
        return "addPilote";
    }

    @RequestMapping(value = "/addPilote", method = RequestMethod.POST)
    public String AddPilote(@ModelAttribute Pilote pilote, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "home";
        }
        System.out.println(pilote);
        piloteService.save(pilote);
        model.addAttribute("pilote", piloteService.findAll());

        return "addPilote";
    }
}
