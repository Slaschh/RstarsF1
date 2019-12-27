package com.rstarschampionship.RstarsF1.Utility;

import com.rstarschampionship.RstarsF1.entity.Privilege;
import com.rstarschampionship.RstarsF1.entity.Role;
import com.rstarschampionship.RstarsF1.entity.UserSecu;
import com.rstarschampionship.RstarsF1.repositories.RoleRepository;
import com.rstarschampionship.RstarsF1.repositories.UserSecuRepository;
import com.rstarschampionship.RstarsF1.services.RoleService;
import com.rstarschampionship.RstarsF1.services.UserSecuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserSecuRepository userRepository;

    @Autowired
    private UserSecuService service;

    @Autowired
    private MessageSource messages;

    @Autowired
    private RoleService roleService;
    private UserSecuService userSecuService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserSecu user = userSecuService.findByEmail(email).get();
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(
                            roleService.findByName("ROLE_USER").get())));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
