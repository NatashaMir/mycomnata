package com.example.restservice.Service;

import com.example.restservice.entity.Storagedb;
import com.example.restservice.repository.StoragedbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class StoragedbService {

    @Autowired
    private final StoragedbRepository storagedbRepository;

    public StoragedbService(StoragedbRepository storagedbRepository) {
        this.storagedbRepository = storagedbRepository;
    }

    public void createStoragedb(Storagedb storagedb) {
        storagedbRepository.save(storagedb);
        storagedbRepository.flush();
    }

    public List<Storagedb> findAll() {
        return storagedbRepository.findAll();
    }

    public String findByHashurl(String hashurl) {
        return storagedbRepository.findByHashurl(hashurl);
    }

}
