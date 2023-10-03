package com.rose.crud.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationResponse {
    private Integer id;
    private String message;
    private Date dateCreated;
    private String quotationDownloadUrl;
    private String informationDownloadUrl;
}
