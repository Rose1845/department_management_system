package com.rose.crud.document.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "documents")
public class Document {

    @Id
//    @Size(min = 1, max = 100, message = "The filename size must be between 1 to 100 letters")
    @Column(name = "file_name")
    private String fileName;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column(name = "date_created")
    private Timestamp dateCreated;

    @UpdateTimestamp
    @Column(name = "date_modified")
    private Timestamp dateModified;

    @Size(min = 5, max = 20)
    private String type;

    @Lob
    @NotNull
    private byte[] content;


    @Override
    public String toString() {
        return "Document{" +
                "fileName='" + fileName + '\'' +
                ", version=" + version +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", type='" + type + '\'' +
                '}';
    }
}
