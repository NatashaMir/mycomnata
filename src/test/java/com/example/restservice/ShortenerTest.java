package com.example.restservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ShortenerTest {

    @Test
    @DisplayName("Check random string:")
    public void testShortenerMethod() {
        assertNotNull(new Shortener().encode("http://shorturl.com:8/lengthen/415207542"));
    }

    @Test
    @DisplayName("Check random string sympols:")
    public void testShortenerMethodCheckSymbols() {
        assertThat(new Shortener().encode("http://shorturl.com:8/lengthen/415207542"), matchesPattern("[A-Za-z0-9]*"));
    }

    @Test
    @DisplayName("Check random string length:")
    public void testShortenerMethodCheckLength() {
        assertThat(new Shortener().encode("http://shorturl.com:8/lengthen/415207542"), hasLength(10));
    }

}
