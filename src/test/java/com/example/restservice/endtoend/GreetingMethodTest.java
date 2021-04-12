package com.example.restservice.endtoend;

import com.example.restservice.Greeting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingMethodTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate; //send requests

    String url = "https://www.vogella.com/tutorials/JUnit/article.html";

    @Test
    @DisplayName("Check hash:")
    public void testGreetingMethod() {
        Greeting tmp = this.restTemplate.getForObject("http://localhost:" + port + "/greeting?name=" + url, Greeting.class);
        System.out.println(tmp);
        Greeting tmp2 = this.restTemplate.getForObject(tmp.getContent(), Greeting.class);
        System.out.println(tmp2);
        assertEquals(new Greeting("Your full URL " + url), tmp2);
    }



}
