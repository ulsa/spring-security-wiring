package com.jayway.myapp.service;

import org.springframework.security.core.Authentication;

public interface MyService {
    Authentication doSomething(Authentication authentication);
}
