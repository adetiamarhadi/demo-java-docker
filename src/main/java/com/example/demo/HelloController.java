package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    @GetMapping
    public String hello() {
        String name = "${NAME}";
        String value = this.environment.getProperty("NAME");
        if (null != value && !value.isEmpty()) {
            name = value;
        }
        return "Hi, " + name;
    }
}
