package com.example.restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "greeting.storagedbt")
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
