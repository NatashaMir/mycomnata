package com.example.restservice;

import com.example.restservice.Service.StoragedbService;
import com.example.restservice.entity.Storagedb;
import org.springframework.stereotype.Component;


@Component(value = "real")
public class StorageAdapterDB implements Storage {

    private final StoragedbService storagedbService;

    public StorageAdapterDB(StoragedbService storagedbService) {
        this.storagedbService = storagedbService;
    }


    @Override
    public void put(String key, String value) {

        storagedbService.createStoragedb(new Storagedb(key, value));
    }

    @Override
    public String get(String key) {

        return storagedbService.findByHashurl(key);

    }
}
