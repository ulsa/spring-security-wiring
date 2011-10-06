package com.jayway.myapp.security;

import com.jayway.myapp.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component("authenticationProvider")
public class MyappAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyService service;

    @Override
    public Authentication authenticate(Authentication authenticationRequest) throws AuthenticationException {
        Authentication authentication = service.doSomething(authenticationRequest);
        if (authentication == null)
            throw new BadCredentialsException("Invalid userid or wrong password");
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
