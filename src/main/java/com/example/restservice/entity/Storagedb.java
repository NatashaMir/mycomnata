package com.example.restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "storagedb")
public class Storagedb {

    @Id
    private int hashurl;

    @Column
    private String fullurl;

    public Storagedb(int hashurl, String fullurl) {
        this.hashurl = hashurl;
        this.fullurl = fullurl;
    }

    public Storagedb() {
    }

}
