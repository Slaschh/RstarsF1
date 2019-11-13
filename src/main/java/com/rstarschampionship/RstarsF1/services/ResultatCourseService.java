package com.rstarschampionship.RstarsF1.services;

import com.rstarschampionship.RstarsF1.entity.ResultatCourse;
import com.rstarschampionship.RstarsF1.repositories.ResultatCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatCourseService {

    @Autowired
    private ResultatCourseRepository resultatCourseRepository;

    public List<ResultatCourse> list()
    {
        return resultatCourseRepository.findAll();
    }
}
