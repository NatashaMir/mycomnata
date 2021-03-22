package com.example.restservice;

import com.example.restservice.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerMethodTest {

    private GreetingController greetingControllerTest;
    private Greeting answerTest;
    private static int articleHash = 18504523;

    @BeforeEach
    public void setUp(){
        greetingControllerTest = new GreetingController();
        greetingControllerTest.greeting("https://www.vogella.com/tutorials/JUnit/article.html");
        answerTest = new Greeting("Your full URL https://www.vogella.com/tutorials/JUnit/article.html");
        System.out.print(greetingControllerTest.hmap.get(articleHash));
        System.out.print(greetingControllerTest.answer(articleHash).getContent());
    }

    @Test
    @DisplayName("Check hash exist:")
    public void testAnswerMethodTrue() {
        assertEquals(greetingControllerTest.answer(articleHash), answerTest);
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
