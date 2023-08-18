package com.mailapp.mailservice.controller;

import com.mailapp.mailservice.dto.request.AddNewMailingRequest;
import com.mailapp.mailservice.dto.response.common.ResponseBody;
import com.mailapp.mailservice.dto.response.common.SuccessfulResponseBody;
import com.mailapp.mailservice.mapper.MailingMapper;
import com.mailapp.mailservice.service.MailingService;
import com.mailapp.mailservice.storage.model.Mailing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/mailings")
@RestController
public class MailingController {
    private final MailingService mailingService;

    private final MailingMapper mailingMapper;

    public MailingController(MailingService mailingService, MailingMapper mailingMapper) {
        this.mailingService = mailingService;
        this.mailingMapper = mailingMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getMailings(Pageable pageable) {
        Page<Mailing> mailings = mailingService.getMailings(pageable);
        ResponseBody responseBody = new SuccessfulResponseBody<>(mailingMapper.mapPage(mailings));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/{mailing-id}")
    public ResponseEntity<ResponseBody> getMailing(@PathVariable("mailing-id") UUID mailingId) {
        Mailing mailing = mailingService.getMailing(mailingId);
        ResponseBody responseBody = new SuccessfulResponseBody<>(mailingMapper.map(mailing));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> addNewMailing(@RequestBody @Valid AddNewMailingRequest request) {
        Mailing newMailing = mailingService.addNewMailing(request);
        ResponseBody responseBody = new SuccessfulResponseBody<>(mailingMapper.map(newMailing));
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }
}
