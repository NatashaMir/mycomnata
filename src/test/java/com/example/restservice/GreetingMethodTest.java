package com.example.restservice;

import com.example.restservice.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingMethodTest {

    private GreetingController greetingControllerTest;
    private Greeting greetingTest;

    @BeforeEach
    public void setUp(){
        greetingControllerTest = new GreetingController();
        greetingTest = new Greeting("Your short URL, shorturl.com/415207542");
    }

    @Test
    @DisplayName("Check hash:")
    public void testGreetingMethod() {
        assertEquals(greetingControllerTest.greeting("https://www.vogella.com/tutorials/JUnit/article.html"), greetingTest);
    }



}
