package com.rose.crud.application.controller;


import com.rose.crud.application.dto.ApplicationDto;
import com.rose.crud.application.dto.ApplicationResponse;
import com.rose.crud.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationObjectService;

    @GetMapping("/")
    public ResponseEntity<List<ApplicationResponse>> allRFQs() {
        return new ResponseEntity<>(applicationObjectService.allFRQs(), HttpStatus.OK);
    }

    @PostMapping(value = "/",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationResponse> save(@Validated ApplicationDto requestForQuotationDto) {
        return new ResponseEntity<>(applicationObjectService.saveRFQ(requestForQuotationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponse> getRFQById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(applicationObjectService.getRFQById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    /*public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @Valid @NotNull @Length(max = 10) @RequestPart(value = "message") String message,
                                    @Valid @NotNull @RequestPart(value = "quotationDocument") MultipartFile quotationDocument,
                                    @Valid @NotNull @RequestPart(value = "informationDocument") MultipartFile termsAndConditions,
                                    @Valid @NotNull @RequestPart(value = "purchaseOrderId") Integer purchaseOrderId
    )*/
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @Validated ApplicationDto applicationObjectDto) {
/*        RequestForQuotationDto requestForQuotationDto = RequestForQuotationDto.builder()
                .termsAndConditions(termsAndConditions)
                .message(message)
                .purchaseOrderId(purchaseOrderId)
                .quotationDocument(quotationDocument)
                .build();*/
//        applicationObjectService.updateRFQ(id, requestForQuotationDto);
        applicationObjectService.updateRFQ(id, applicationObjectDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        applicationObjectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
