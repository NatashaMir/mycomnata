package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class AnswerMethodTest {

    @Autowired
    private GreetingController greetingControllerTest;
    String url = "https://www.vogella.com/tutorials/JUnit/article.html";

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("Check hash exist:")
    public void testAnswerMethodTrue() {
        greetingControllerTest.greeting(url);
        int hash = url.hashCode();
        assertEquals(new Greeting("Your full URL https://www.vogella.com/tutorials/JUnit/article.html"), greetingControllerTest.answer(hash));
    }

    @Test
    @DisplayName("Check hash doesn`t exist:")
    public void testAnswerMethodFalse() {
        assertEquals(new Greeting("Your full URL doesn`t exists"), greetingControllerTest.answer(123456789));
    }


}
