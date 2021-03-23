package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;


@SpringBootTest()
public class GreetingMethodTest {

    @MockBean
    Storage storage;

    @Autowired
    private GreetingController greetingControllerTest;
    String url = "https://www.vogella.com/tutorials/JUnit/article.html";

    @BeforeEach
    public void setUp(){
    }

    @Test
    @DisplayName("Check hash:")
    public void testGreetingMethod() {
        doNothing().when(storage).put("" + url.hashCode(), url);
        assertEquals(new Greeting("Your short URL shorturl.com/415207542"), greetingControllerTest.greeting(url));
    }



}
