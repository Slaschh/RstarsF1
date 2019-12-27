package com.rstarschampionship.RstarsF1.controller;

import com.rstarschampionship.RstarsF1.entity.Pilote;
import com.rstarschampionship.RstarsF1.repositories.PiloteRepository;
import com.rstarschampionship.RstarsF1.services.PiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ControllerEdit {

    @Autowired
    private PiloteService piloteService;

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Pilote pilote,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            pilote.setIdPilote(id);
            return "update-user";
        }

        piloteService.save(pilote);
        model.addAttribute("pilote", piloteService.findAll());
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Pilote pilote = piloteService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        piloteService.delete(pilote);
        model.addAttribute("users", piloteService.findAll());
        return "index";
    }
}
