package com.rstarschampionship.RstarsF1.controller;

import com.rstarschampionship.RstarsF1.entity.ResultatCourse;
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

    @Autowired
    public ControllerAddResultat(ResultatCourseService resultatCourseService) {
        this.resultatCourseService = resultatCourseService;
    }

    @RequestMapping(value = "/addResultat", method = RequestMethod.GET)
    public String AddResultat(Model model) {
        ResultatCourse addResultat = new ResultatCourse();
        model.addAttribute("resultatCourse", addResultat);

        return "addResultat";
    }

    @RequestMapping(value = "/addResultat", method = RequestMethod.POST)
    public String AddResultat(@ModelAttribute ResultatCourse resultatCourse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "home";
        }
        System.out.println(resultatCourse);
        resultatCourseService.save(resultatCourse);
        model.addAttribute("resultatCourse", resultatCourseService.findAll());

        return "addResultat";
    }
}
