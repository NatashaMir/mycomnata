package com.example.restservice;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component(value = "inMemory")
public class StorageHashMap implements Storage{

    private final Map<String, String> hmap = new ConcurrentHashMap<>();

    @Override
    public void put(String key, String value) {
        hmap.put(key, value);
    }

    @Override
    public String get(String key) {
        return hmap.get(key);
    }

}
