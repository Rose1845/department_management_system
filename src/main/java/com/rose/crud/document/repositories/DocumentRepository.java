package com.rose.crud.document.repositories;

import com.rose.crud.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
    //
//    @Query("SELECT new Document ( d.dateCreated, d.dateModified, d.type, d.fileName)" +
//            " FROM Document d WHERE d.fileName=:fileName")
    Optional<Document> findByFileName(@Param("fileName") String fileName);
    //
//    @Query("SELECT new Document (d.dateCreated, d.dateModified, d.type, d.fileName)" +
//            " FROM Document d order by d.dateCreated")
    @Override
    List<Document> findAll();

}
