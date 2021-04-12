package com.example.restservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ShortenerTest {

    @Test
    @DisplayName("Check rendom string:")
    public void testShortenerMethod() {
        assertNotNull(new Shortener().encode("http://shorturl.com:8/answer/415207542"));
    }

}
