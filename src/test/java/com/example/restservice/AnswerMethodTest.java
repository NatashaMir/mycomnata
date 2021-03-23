package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerMethodTest {

    private GreetingController greetingControllerTest;
    String url = "https://www.vogella.com/tutorials/JUnit/article.html";

    @BeforeEach
    public void setUp(){
        greetingControllerTest = new GreetingController();
    }

    @Test
    @DisplayName("Check hash exist:")
    public void testAnswerMethodTrue() {
        greetingControllerTest.greeting(url);
        int hash = url.hashCode();
        assertEquals(new Greeting("Your full URL https://www.vogella.com/tutorials/JUnit/article.html"), greetingControllerTest.answer(hash));
    }

//    @Test
//    @DisplayName("Check hash is empty:")
//    public void testAnswerMethodNull() {
//        assertEquals(greetingControllerTest.greeting("https://www.vogella.com/tutorials/JUnit/article.html"), answerTest);
//    }
//
//    @Test
//    @DisplayName("Check hash doesn`t exist:")
//    public void testAnswerMethodFalse() {
//        assertEquals(greetingControllerTest.greeting("https://www.vogella.com/tutorials/JUnit/article.html"), answerTest);
//    }



}
