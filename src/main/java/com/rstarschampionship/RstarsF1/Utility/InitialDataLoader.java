package com.rstarschampionship.RstarsF1.Utility;

import com.rstarschampionship.RstarsF1.entity.Privilege;
import com.rstarschampionship.RstarsF1.entity.Role;
import com.rstarschampionship.RstarsF1.entity.UserSecu;
import com.rstarschampionship.RstarsF1.services.PrivilegeService;
import com.rstarschampionship.RstarsF1.services.RoleService;
import com.rstarschampionship.RstarsF1.services.UserSecuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserSecuService userSecuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));


        alreadySetup = true;
    }

    @Transactional
        Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege;
        if (privilegeService.findByName(name).isPresent())
            return privilegeService.findByName(name).get();
             privilege = new Privilege(name);
            privilegeService.save(privilege);

        return null;
    }

    @Transactional
             Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role;
        if (roleService.findByName(name).isPresent()) {
            roleService.findByName(name).get();
            role = new Role(name);
            role.setPrivileges(privileges);
            roleService.save(role);
        }
        return null;
    }
}