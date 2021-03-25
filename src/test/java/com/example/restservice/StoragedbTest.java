package com.example.restservice;

import com.example.restservice.Service.StoragedbService;
import com.example.restservice.entity.Storagedb;
import com.example.restservice.repository.StoragedbRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StoragedbTest {

    @Autowired
    private StoragedbService storagedbService;

    @Autowired
    private StoragedbRepository storagedbRepository;

    @Test
    public void testSaveNewItemStorage(){

        storagedbService.createStoragedb(new Storagedb());
        String urlfull = storagedbRepository.findByHashurl("415207542");
        assertEquals(urlfull, "https://www.vogella.com/tutorials/JUnit/article.html");

    }
}
