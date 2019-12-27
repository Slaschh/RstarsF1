package com.rstarschampionship.RstarsF1.controller;

import com.rstarschampionship.RstarsF1.entity.ResultatCourse;
import com.rstarschampionship.RstarsF1.services.PiloteService;
import com.rstarschampionship.RstarsF1.services.ResultatCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerAddResultat {

    private final ResultatCourseService resultatCourseService;
    private final PiloteService piloteService;

    @Autowired
    public ControllerAddResultat(ResultatCourseService resultatCourseService, PiloteService piloteService) {
        this.resultatCourseService = resultatCourseService;
        this.piloteService = piloteService;
    }

    @RequestMapping(value = "/addResultat", method = RequestMethod.GET)
    public String AddResultat(Model model) {
        ResultatCourse addResultat = new ResultatCourse();
        model.addAttribute("resultatCourse", addResultat);
        model.addAttribute("pageTitle", "Ajout d'un résultat");
        model.addAttribute("listPilote", piloteService.findAll());

        return "addResultat";
    }

    @RequestMapping(value = "/addResultat", method = RequestMethod.POST)
    public String AddResultat(@ModelAttribute ResultatCourse resultatCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("resultatCourse", resultatCourse);
            return "addResultat";
        }
        System.out.println(resultatCourse);
        resultatCourseService.save(resultatCourse);


        return "home";
    }
}
