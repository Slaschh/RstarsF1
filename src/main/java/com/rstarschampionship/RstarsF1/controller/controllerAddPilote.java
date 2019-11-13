package com.rstarschampionship.RstarsF1.controller;


import com.rstarschampionship.RstarsF1.entity.Pilote;
import com.rstarschampionship.RstarsF1.repositories.PiloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class controllerAddPilote {

    private final PiloteRepository piloteRepository;

    @Autowired
    public controllerAddPilote (PiloteRepository piloteRepository)
    {
        this.piloteRepository = piloteRepository;
    }

    @RequestMapping( value = "/addPilote", method = RequestMethod.GET)
    public String AddPilote (Model model)
    {
        Pilote addpilote = new Pilote();
        model.addAttribute("Pilote", addpilote);


        return "addPilote" ;
    }

    @RequestMapping(value = "/addPilote", method = RequestMethod.POST)
    public String AddPilote (@Valid Pilote pilote, BindingResult result, Model model)
    {
    piloteRepository.save(pilote);
    model.addAttribute("pilotes", piloteRepository.findAll());


        return "addPilote";
    }
}
