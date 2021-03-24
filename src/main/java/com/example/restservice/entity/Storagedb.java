package com.example.restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "storagedb")
public class Storagedb {

    @Column
    private Long hashurl;

    @Column
    private String fullurl;

}
