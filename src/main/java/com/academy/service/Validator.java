package com.academy.service;

import org.springframework.stereotype.Component;

@Component
public abstract class Validator <T> {

    public abstract <T> void validate (T t);
}
