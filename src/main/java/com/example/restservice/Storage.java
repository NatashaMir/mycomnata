package com.example.restservice;

public interface Storage {

    void put(String key, String value);

    String get(String key);

}
