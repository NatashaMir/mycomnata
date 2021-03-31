package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final Storage hmap;

    private static final String template = "Your short URL shorturl.com/%s";
    private static final String template_answer = "Your full URL %s";


    public GreetingController(@Qualifier("real") Storage storage) {
        hmap = storage;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        hmap.put("" + name.hashCode(), name);
        return new Greeting(String.format(template, name.hashCode()));
    }

    @GetMapping("/answer")
    public Greeting answer(@RequestParam(value = "shortname", defaultValue = "") String shortname) {
        String answer = hmap.get(shortname.substring(shortname.lastIndexOf('/')+1, shortname.length() - 1));
        if (answer != null) {
            return new Greeting(String.format(template_answer, answer));
        } else {
            return new Greeting(String.format(template_answer, "doesn`t exists"));
        }
    }
}
