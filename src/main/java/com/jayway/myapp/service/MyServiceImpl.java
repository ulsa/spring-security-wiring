package com.jayway.myapp.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public Authentication doSomething(Authentication authentication) {
        System.out.println("in MyServiceImpl#doSomething()");
        return authentication;
    }
}
