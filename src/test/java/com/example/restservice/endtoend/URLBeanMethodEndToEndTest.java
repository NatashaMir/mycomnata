package com.example.restservice.endtoend;

import com.example.restservice.URLBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class URLBeanMethodEndToEndTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate; //send requests

    String url = "https://www.vogella.com/tutorials/JUnit/article.html";

    @Test
    @DisplayName("Check hash:")
    public void testGreetingMethod() {
        URLBean tmp = this.restTemplate.getForObject("http://localhost:" + port + "/shorten?url=" + url, URLBean.class);
        System.out.println(tmp);
        URLBean tmp2 = this.restTemplate.getForObject(tmp.getUrl(), URLBean.class);
        System.out.println(tmp2);
        assertEquals(new URLBean("Your full URL " + url), tmp2);
    }



}
