package com.rstarschampionship.RstarsF1.repositories;

import com.rstarschampionship.RstarsF1.entity.Role;
import com.rstarschampionship.RstarsF1.entity.UserSecu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role,Long> {


    Optional<Role> findByName(String name);


}
