package com.rstarschampionship.RstarsF1.services;

import com.rstarschampionship.RstarsF1.entity.Privilege;
import com.rstarschampionship.RstarsF1.repositories.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    public Optional<Privilege> findByName(String name) {return privilegeRepository.findByName(name);}

    public Privilege save (Privilege privilege) {return privilegeRepository.save(privilege);}
}
