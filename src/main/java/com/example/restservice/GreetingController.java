package com.example.restservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private final Storage hmap;


    private final ServerPortService server;

    private static final String template_answer = "Your full URL %s";

    public GreetingController(@Qualifier("real") Storage storage, ServerPortService server) {
        hmap = storage;
        this.server = server;
    }

    @GetMapping("/shorten")
    public Greeting shorten(@RequestParam(value = "url", defaultValue = "") String url) {
        hmap.put("" + url.hashCode(), url);
        return new Greeting(String.format("http://shorturl.com:" + server.getPort() + "/lengthen/%s", url.hashCode()));
    }

    @GetMapping("/lengthen/{shortURL}")
    public Greeting lengthen(@PathVariable(value = "shortURL") String shortURL) {
        String answer = hmap.get(shortURL);
        if (answer != null) {
            return new Greeting(String.format(template_answer, answer));
        } else {
            return new Greeting(String.format(template_answer, "doesn't exists"));
        }
    }
}
