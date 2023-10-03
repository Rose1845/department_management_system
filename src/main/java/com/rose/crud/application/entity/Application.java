package com.rose.crud.application.entity;


import com.rose.crud.document.entity.Document;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column(name = "date_created")
    private Timestamp dateCreated;

    @UpdateTimestamp
    @Column(name = "date_modified")
    private Timestamp dateModified;

    @Column(columnDefinition = "varchar(500)")
    private String message;

    @OneToOne(cascade = CascadeType.ALL)
    private Document informationDocument;

    @OneToOne(cascade = CascadeType.ALL)
    private Document quotationDocument;

    private Integer purchaseOrderId;

}
