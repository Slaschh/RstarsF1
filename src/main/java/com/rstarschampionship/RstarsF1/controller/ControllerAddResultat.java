package com.rstarschampionship.RstarsF1.controller;

import com.rstarschampionship.RstarsF1.entity.ResultatCourse;
import com.rstarschampionship.RstarsF1.repositories.ResultatCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ControllerAddResultat
{
    private final ResultatCourseRepository resultatCourseRepository;

    @Autowired
    public ControllerAddResultat (ResultatCourseRepository resultatCourseRepository)
    {
        this.resultatCourseRepository = resultatCourseRepository;
    }

    @RequestMapping (value = "/addResultat", method = RequestMethod.GET)
    public String AddResultat (Model model)
    {
        ResultatCourse  addResultat = new ResultatCourse();
        model.addAttribute("Resultat", addResultat);

    return "addResultat";
    }

    @RequestMapping(value = "/addResultat", method =  RequestMethod.POST)
    public String AddResultat (@Valid ResultatCourse resultatCourse, Model model, BindingResult result)
    {
        resultatCourseRepository.save(resultatCourse);
        model.addAttribute("resultatsCourse", resultatCourseRepository.findAll());


        return "addResultat";
    }
}
