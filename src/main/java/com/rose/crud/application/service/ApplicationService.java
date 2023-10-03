package com.rose.crud.application.service;


import com.rose.crud.application.dto.ApplicationDto;
import com.rose.crud.application.dto.ApplicationResponse;
import com.rose.crud.application.entity.Application;
import com.rose.crud.application.repository.ApplicationRepository;
import com.rose.crud.document.entity.Document;
import com.rose.crud.document.mappers.ApplicationMapper;
import com.rose.crud.document.repositories.DocumentRepository;
import com.rose.crud.document.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationObjectRepository;
//    @Qualifier("applicationMapperImpl",value="")
    private final ApplicationMapper applicationObjectMapper;
    private final DocumentService documentService;
    private final DocumentRepository documentRepository;

    public List<ApplicationResponse> allFRQs() {
        List<ApplicationResponse> responses = new ArrayList<>();
        applicationObjectRepository.findAll().forEach(requestForQuotation -> {
            responses.add(createResponse(requestForQuotation));
        });
        return responses;
    }

    public ApplicationResponse getRFQById(Integer id) {
        Application applicationObject = applicationObjectRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("The RFQ with id: " + id + " is not available!");
        });
        return createResponse(applicationObject);
    }

    public ApplicationResponse saveRFQ(ApplicationDto requestForQuotationDto) {
        Application applicationObject =
                applicationObjectMapper.applicationDtoToApplication(requestForQuotationDto);
        applicationObject.getQuotationDocument().setType("Quotation");
        applicationObject.getInformationDocument().setType("Information");
        return createResponse(applicationObjectRepository.save(applicationObject));
    }

    public void updateRFQ(Integer id, ApplicationDto requestForQuotationDto) {

        Application newApplicationObject =
                applicationObjectMapper.applicationDtoToApplication(requestForQuotationDto);

        applicationObjectRepository.findById(id).ifPresentOrElse(requestForQuotation -> {

                    Document oldInformationDocument = requestForQuotation.getInformationDocument();
                    Document oldQuotation = requestForQuotation.getQuotationDocument();
                    Document newInformationDocument = newApplicationObject.getInformationDocument();
                    Document newQuotation = newApplicationObject.getQuotationDocument();

                    // if the provided terms and condition exists, just update the content, else overwrite
                    if (oldInformationDocument.getFileName().equals(newInformationDocument.getFileName())) {
                        documentRepository.findByFileName(newInformationDocument.getFileName()).ifPresent(document -> {
                            document.setContent(newInformationDocument.getContent());
                            requestForQuotation.setInformationDocument(documentRepository.save(document));
                        });
                    } else {
                        newInformationDocument.setType("Information");
                        requestForQuotation.setInformationDocument(documentRepository.save(newInformationDocument));
                        documentService.deleteFile(oldInformationDocument.getFileName());
                    }

                    // if the provided quotation exist, change the content, else overwrite
                    if (oldQuotation.getFileName().equals(newQuotation.getFileName())) {
                        documentRepository.findByFileName(newQuotation.getFileName()).ifPresent(document -> {
                            document.setContent(newQuotation.getContent());
                            requestForQuotation.setQuotationDocument(documentRepository.save(document));
                        });
                    } else {
                        newQuotation.setType("Quotation attachment");
                        requestForQuotation.setQuotationDocument(documentRepository.save(newQuotation));
                        documentService.deleteFile(oldQuotation.getFileName());
                    }
                    // update the message
                    requestForQuotation.setMessage(newApplicationObject.getMessage());
                    requestForQuotation.setPurchaseOrderId(newApplicationObject.getPurchaseOrderId());
                },
                () -> {
                    throw new NoSuchElementException(" The Application with id: " + id + " is not found!");
                });
    }

    public void deleteById(Integer id) {
        applicationObjectRepository.findById(id).ifPresentOrElse(applicationObjectRepository::delete, () -> {
            throw new NoSuchElementException("Application with id: " + id + " not found!");
        });
    }

    private ApplicationResponse createResponse(Application applicationObject) {
        Document quotationDoc = applicationObject.getQuotationDocument();
        Document informationDocument = applicationObject.getInformationDocument();

        String quotationDocName = StringUtils.cleanPath(Objects.requireNonNull(quotationDoc.getFileName()));
        String termsAndConditionDocName = StringUtils.cleanPath(Objects.requireNonNull(informationDocument.getFileName()));

        String quotationUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/documents/download/")
                .path(quotationDocName)
                .toUriString();
        String informationDocumentUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/documents/download/")
                .path(termsAndConditionDocName)
                .toUriString();
        return ApplicationResponse.builder()
                .id(applicationObject.getId())
                .dateCreated(applicationObject.getDateCreated())
                .message(applicationObject.getMessage())
                .quotationDownloadUrl(quotationUrl)
                .informationDownloadUrl(informationDocumentUrl)
                .build();
    }
}
