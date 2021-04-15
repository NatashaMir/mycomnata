package com.example.restservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class URLBeanController {

    private final Storage hmap;
    private final ServerPortService server;
    private final Shortener shortener;

    private static final String template_answer = "Your full URL %s";

    public URLBeanController(@Qualifier("real") Storage storage, ServerPortService server, Shortener shortener) {
        hmap = storage;
        this.server = server;
        this.shortener = shortener;
    }

    @GetMapping("/shorten")
    public URLBean shorten(@RequestParam(value = "url", defaultValue = "") String url) {
        String shortUrl = shortener.encode(url);
        hmap.put("" + shortUrl, url);
        return new URLBean(String.format("http://shorturl.com:" + server.getPort() + "/lengthen/%s", shortUrl));
    }

    @GetMapping("/lengthen/{shortURL}")
    public URLBean lengthen(@PathVariable(value = "shortURL") String shortURL) {
        String answer = hmap.get(shortURL);
        if (answer != null) {
            return new URLBean(String.format(template_answer, answer));
        } else {
            return new URLBean(String.format(template_answer, "doesn't exists"));
        }
    }
}
