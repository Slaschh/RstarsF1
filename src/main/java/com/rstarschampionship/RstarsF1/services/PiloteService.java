package com.rstarschampionship.RstarsF1.services;

import com.rstarschampionship.RstarsF1.entity.Pilote;
import com.rstarschampionship.RstarsF1.repositories.PiloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiloteService {

    @Autowired
    PiloteRepository piloteRepository;


    public List<Pilote> findAll() {
        return piloteRepository.findAll();
    }

    public void save(Pilote pilote) {
        piloteRepository.save(pilote);
    }

}
