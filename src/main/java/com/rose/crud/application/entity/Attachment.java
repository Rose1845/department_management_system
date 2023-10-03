package com.rose.crud.application.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fileName;
    private String fileTYpe;
    @Lob
    private byte[] data;


    public Attachment() {

    }

    public Attachment(String id, String fileName, String fileTYpe, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.fileTYpe = fileTYpe;
        this.data = data;
    }

    public Attachment(String fileName, String contentType, byte[] bytes) {
    }
}
