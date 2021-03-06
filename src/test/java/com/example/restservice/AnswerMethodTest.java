package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest()
public class AnswerMethodTest {

    @MockBean(name = "real")
    Storage storage;

    @Autowired
    private URLBeanController URLBeanControllerTest;
    String url = "https://www.vogella.com/tutorials/JUnit/article.html";

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("Check hash exist:")
    public void testAnswerMethodTrue() {
        doReturn(url).when(storage).get("" + url.hashCode());
        //URLBeanControllerTest.shorten(url);
        String hash = "" + url.hashCode();
        assertEquals(new URLBean("Your full URL https://www.vogella.com/tutorials/JUnit/article.html"), URLBeanControllerTest.lengthen(hash));
    }

    @Test
    @DisplayName("Check hash doesn`t exist:")
    public void testAnswerMethodFalse() {
        assertEquals(new URLBean("Your full URL doesn't exists"), URLBeanControllerTest.lengthen("123456789"));
    }


}
