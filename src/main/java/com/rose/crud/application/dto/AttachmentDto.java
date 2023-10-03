package com.rose.crud.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDto {
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private Long fileSize;
}
