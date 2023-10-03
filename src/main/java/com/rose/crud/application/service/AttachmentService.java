package com.rose.crud.application.service;

import com.rose.crud.application.entity.Attachment;
import com.rose.crud.application.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public Attachment saveFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try{
            if(fileName.contains("...")){
                throw new Exception("file contains ");
            }
            Attachment attachment = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes()
                    );
            return attachmentRepository.save(attachment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Attachment getDownloadFile(String fileId) throws Exception {

        return attachmentRepository.findById(fileId)
                .orElseThrow();
    }
}
