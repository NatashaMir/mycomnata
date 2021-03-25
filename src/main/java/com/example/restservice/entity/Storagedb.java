package com.example.restservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "storagedb")
public class Storagedb {

    @Id
    private Long hashurl;

    @Column
    private String fullurl;

}
