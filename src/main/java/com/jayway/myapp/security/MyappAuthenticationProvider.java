package com.jayway.myapp.security;

import com.jayway.myapp.service.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component("authenticationProvider")
public class MyappAuthenticationProvider implements AuthenticationProvider, ApplicationContextAware {

    @Autowired
    private MyService service;

    public MyappAuthenticationProvider() {
        System.out.println("=====> Creating " + this);
        StringWriter out = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(out));
        System.out.println("=====> No exception has been thrown, just printing the current stack trace: "
                + out.toString());
    }

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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("=====> " + this + ": My applicationContext is: " + applicationContext);
    }
}
