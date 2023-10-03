package com.rose.crud.document.mappers;

import com.rose.crud.application.dto.ApplicationDto;
import com.rose.crud.application.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Mapper( componentModel = "spring",uses = MultipartDocumentMapper.class)
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
    Application applicationDtoToApplication(ApplicationDto applicationObjectDto);
}