package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Your short URL, shorturl.com/%s";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
        return new Greeting(String.format(template, name.hashCode()));
    }

}
