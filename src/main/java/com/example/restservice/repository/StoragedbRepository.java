package com.example.restservice.repository;

import com.example.restservice.entity.Storagedb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository

public interface StoragedbRepository extends JpaRepository<Storagedb, Long> {

    @Query(nativeQuery = true, value = "SELECT s.fullurl FROM greeting.storagedbt s WHERE s.hashurl = :hashurl")
    String findByHashurl(@Param("hashurl") String hashurl);

}