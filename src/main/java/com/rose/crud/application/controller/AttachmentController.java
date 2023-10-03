package com.rose.crud.application.controller;

import com.rose.crud.application.dto.AttachmentDto;
import com.rose.crud.application.entity.Attachment;
import com.rose.crud.application.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }
  @PostMapping(value = "upload",
          consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
    public AttachmentDto uploadFile(@RequestParam("file") MultipartFile file){
        Attachment attachment = attachmentService.saveFile(file);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

//        AttachmentDto attachmentDto = AttachmentDto.builder()
//                .fileType(file.getContentType())
//                .downloadUrl(downloadUrl)
//                .fileName(file.getName())
//                .fileSize(file.getSize())
//                .build();

        return new AttachmentDto(file.getName(),
                downloadUrl,
                file.getContentType(),
                file.getSize()
                );
//      return attachmentService.saveFile( AttachmentDto AttachmentDto.builder()
//              .fileType(file.getContentType())
//              .downloadUrl(downloadUrl)
//              .fileName(file.getName())
//              .fileSize(file.getSize())
//              .build());
    }
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId
    ) throws Exception {
        Attachment attachment= attachmentService.getDownloadFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileTYpe()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment filename"+ attachment.getFileName() + "/")
                .body(new ByteArrayResource(attachment.getData()));
    }
}
