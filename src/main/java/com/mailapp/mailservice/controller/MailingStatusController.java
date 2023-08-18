package com.mailapp.mailservice.controller;

import com.mailapp.mailservice.dto.request.AddNewMailingStatusRequest;
import com.mailapp.mailservice.dto.response.common.ResponseBody;
import com.mailapp.mailservice.dto.response.common.SuccessfulResponseBody;
import com.mailapp.mailservice.mapper.MailingStatusMapper;
import com.mailapp.mailservice.service.MailingStatusService;
import com.mailapp.mailservice.storage.model.MailingStatus;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/mailings/{mailing-id}/statuses")
@RestController
public class MailingStatusController {
    private final MailingStatusService mailingStatusService;

    private final MailingStatusMapper mailingStatusMapper;

    public MailingStatusController(MailingStatusService mailingStatusService, MailingStatusMapper mailingStatusMapper) {
        this.mailingStatusService = mailingStatusService;
        this.mailingStatusMapper = mailingStatusMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getMailingStatuses(@PathVariable("mailing-id") UUID mailingId, Pageable pageable) {
        Page<MailingStatus> mailingStatuses = mailingStatusService.getMailingStatuses(mailingId, pageable);
        ResponseBody responseBody = new SuccessfulResponseBody<>(mailingStatusMapper.mapPage(mailingStatuses));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> addNewMailingStatus(@PathVariable("mailing-id") UUID mailingId,
                                                            @RequestBody @Valid AddNewMailingStatusRequest request) {
        MailingStatus newMailingStatus = mailingStatusService.addNewMailingStatus(mailingId, request);
        ResponseBody responseBody = new SuccessfulResponseBody<>(mailingStatusMapper.map(newMailingStatus));
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }
}
