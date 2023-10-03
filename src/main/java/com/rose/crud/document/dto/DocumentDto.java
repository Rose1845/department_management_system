package com.rose.crud.document.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {

    @NotBlank
    private String type;

    @Null
    private String fileName;

}
