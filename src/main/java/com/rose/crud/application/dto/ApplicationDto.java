package com.rose.crud.application.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDto {
    @NotBlank
    private String message;

    @NotNull
    private MultipartFile quotationDocument;

    @NotNull
    private MultipartFile informationDocument;


}
