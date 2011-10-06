package com.jayway.myapp.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService, ApplicationContextAware {
    public MyServiceImpl() {
        System.out.println("=====> Creating " + this);
    }

    @Override
    public Authentication doSomething(Authentication authentication) {
        System.out.println("in MyServiceImpl#doSomething()");
        return authentication;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("=====> " + this + ": My applicationContext is: " + applicationContext);
    }
}
