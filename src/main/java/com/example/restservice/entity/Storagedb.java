package com.example.restservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "greeting", name = "storagedbt")
public class Storagedb {

    @Id
    private String hashurl;

    @Column
    private String fullurl;

    public Storagedb(String hashurl, String fullurl) {
        this.hashurl = hashurl;
        this.fullurl = fullurl;
    }

    public Storagedb() {
    }

}
