package com.rstarschampionship.RstarsF1.services;

import com.rstarschampionship.RstarsF1.entity.Role;
import com.rstarschampionship.RstarsF1.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository  roleRepository;

    public Optional<Role> findByName (String name) {return roleRepository.findByName(name);}

    public Role save (Role role) {return roleRepository.save(role);}
}
