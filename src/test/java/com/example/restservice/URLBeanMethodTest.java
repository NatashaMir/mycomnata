package com.example.restservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;


@SpringBootTest()
public class URLBeanMethodTest {

    @MockBean(name = "real")
    Storage storage;

    @MockBean
    ServerPortService serverPort;

    @MockBean
    Shortener shortener;


    @Autowired
    private URLBeanController URLBeanController;
    String url = "https://www.vogella.com/tutorials/JUnit/article.html";


    @Test
    @DisplayName("Check hash")
    public void testGreetingMethod() {
        doReturn(8).when(serverPort).getPort();
        doReturn("happyEnd").when(shortener).encode(url);
        assertEquals(new URLBean("http://shorturl.com:8/lengthen/happyEnd"), URLBeanController.shorten(url));
    }



}
