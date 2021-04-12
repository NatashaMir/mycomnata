package com.example.restservice;

import com.example.restservice.entity.Storagedb;
import com.example.restservice.repository.StoragedbRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class StoragedbTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StoragedbRepository storagedbRepository;

    @Transactional
    @Test
    public void testSaveNewItemStorage(){
        entityManager.persist(new Storagedb("415207542", "https://www.vogella.com/tutorials/JUnit/article.html"));
        String urlfull = storagedbRepository.findByHashurl("415207542");
        assertEquals(urlfull, "https://www.vogella.com/tutorials/JUnit/article.html");
    }
}
