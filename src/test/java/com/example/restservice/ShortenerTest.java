package com.example.restservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.matchesPattern;


public class ShortenerTest {

    private String url = "http://shorturl.com:8/lengthen/415207542";
    private Shortener shortener = new Shortener();

    @Test
    @DisplayName("Check random string symbols:")
    public void testShortenerMethodCheckSymbols() {
        assertThat(shortener.encode(url), matchesPattern("[A-Za-z0-9]*"));
    }

    @Test
    @DisplayName("Check random string length:")
    public void testShortenerMethodCheckLength() {
        assertThat(shortener.encode(url), hasLength(10));
    }

}
