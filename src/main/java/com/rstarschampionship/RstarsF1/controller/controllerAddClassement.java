package com.rstarschampionship.RstarsF1.controller;

import com.rstarschampionship.RstarsF1.entity.Classement;
import com.rstarschampionship.RstarsF1.entity.addClassement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.rstarschampionship.RstarsF1.entity.Classement.classement;

@Controller
public class controllerAddClassement {


    @RequestMapping(value="/addClassement" , method = RequestMethod.GET)
    public String AddClassement(Model model)
    {
        addClassement addclassement = new addClassement();
        model.addAttribute("addClassement", addclassement);

        return "addClassement";
    }

    @RequestMapping(value = "/addClassement", method = RequestMethod.POST)
    public String saveclassement (Model model, @ModelAttribute("addClassement") addClassement addclassement)
    {

        String nom_pilote = addclassement.getNom_pilote();
        String nom_ecurie = addclassement.getNom_ecurie();
        Integer place = addclassement.getPlace();
        String circuit = addclassement.getCircuit();
        String modificateur = addclassement.getModificateur();


        if (nom_pilote != null && nom_pilote.length() > 0 //
         && nom_ecurie != null && nom_ecurie.length() > 0
        && place != null && place > 0 ) {
            Classement newClassement = new Classement(nom_pilote, nom_ecurie, place, circuit, modificateur);
            classement.add(newClassement);

            return "redirect:/classement";
        }

        return "addClassement";
    }

}
