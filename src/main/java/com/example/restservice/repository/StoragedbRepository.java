package com.example.restservice.repository;

import com.example.restservice.entity.Storagedb;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
@Lazy

public interface StoragedbRepository extends JpaRepository<Storagedb, Long> {

    @Query("SELECT s.fullurl FROM springjpadb.storagedb s WHERE s.hashurl = ?1")
    String findByHashurl(String hashurl);

}