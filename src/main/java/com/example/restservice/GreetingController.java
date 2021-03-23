package com.example.restservice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final Map<Integer, String> hmap = new ConcurrentHashMap<>();

    private static final String template = "Your short URL shorturl.com/%s";
    private static final String template_answer = "Your full URL %s";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        hmap.put(name.hashCode(), name);
        return new Greeting(String.format(template, name.hashCode()));
    }

    @GetMapping("/answer")
    public Greeting answer(@RequestParam(value = "shortname", defaultValue = "") int shortname) {
        String answer = hmap.get(shortname);
        if (answer != null) {
            return new Greeting(String.format(template_answer, answer));
        } else {
            return new Greeting(String.format(template_answer, "doesn`t exists"));
        }
    }
}
