package com.rstarschampionship.RstarsF1.services;

import com.rstarschampionship.RstarsF1.entity.UserSecu;
import com.rstarschampionship.RstarsF1.repositories.UserSecuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserSecuService implements UserDetailsService {

    @Autowired
    UserSecuRepository userSecuRepository;

    @Autowired
    public UserSecuService(UserSecuRepository userSecuRepository) {
        this.userSecuRepository = userSecuRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        UserSecu user = userSecuRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    public UserSecu save (UserSecu user) {return userSecuRepository.save(user);}

    public Optional<UserSecu> findByEmail(String email) {return userSecuRepository.findByEmail(email);}

}
