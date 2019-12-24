package com.rstarschampionship.RstarsF1.Utility;


import com.rstarschampionship.RstarsF1.services.UserSecuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {
    @Autowired
    UserSecuService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = auth.getName();
        String password = auth.getCredentials()
                .toString();
        UserDetails user = userDetailsService.loadUserByUsername(name);
        if (user == null | password != user.getPassword() ) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}