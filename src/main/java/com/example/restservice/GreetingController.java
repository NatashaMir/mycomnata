package com.example.restservice;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    private String answer = "";
    private static final String template = "Your short URL shorturl.com/%s";
    private static final String template_answer = "Your full URL %s";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
        hmap.put(name.hashCode(), name);
        return new Greeting(String.format(template, name.hashCode()));
    }

    @GetMapping("/answer")
    public Greeting answer(@RequestParam(value = "shortname", defaultValue = "") int shortname){
        answer =  hmap.get(shortname);
        if (answer != null) {
            return new Greeting(String.format(template_answer, answer));
        } else {
            if (hmap.containsKey(shortname)) {
                return new Greeting(String.format(template_answer, ""));
            } else {
                return new Greeting(String.format(template_answer, "doesn`t exists"));
            }
        }
    }
}
