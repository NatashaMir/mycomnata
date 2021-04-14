package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Shortener {

    public String encode(String input) {

        int leftLimit = '0';
        int rightLimit = 'z';
        int targetStringLength = 10;

        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= '9' || i >= 'A') && (i <= 'Z' || i >= 'a'))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}