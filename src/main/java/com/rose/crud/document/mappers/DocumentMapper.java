package com.rose.crud.document.mappers;
import com.rose.crud.document.dto.DocumentDto;
import com.rose.crud.document.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Mapper( componentModel = "spring",uses = MultipartDocumentMapper.class)
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    Document documentDtoToDocument(DocumentDto documentDto);

}
