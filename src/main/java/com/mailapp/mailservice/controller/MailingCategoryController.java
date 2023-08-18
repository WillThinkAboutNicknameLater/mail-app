package com.mailapp.mailservice.controller;

import com.mailapp.mailservice.dto.response.common.ResponseBody;
import com.mailapp.mailservice.dto.response.common.SuccessfulResponseBody;
import com.mailapp.mailservice.mapper.MailingCategoryMapper;
import com.mailapp.mailservice.service.MailingCategoryService;
import com.mailapp.mailservice.storage.model.MailingCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/mailing-categories")
@RestController
public class MailingCategoryController {
    private final MailingCategoryService mailingCategoryService;

    private final MailingCategoryMapper mailingCategoryMapper;

    public MailingCategoryController(MailingCategoryService mailingCategoryService, MailingCategoryMapper mailingCategoryMapper) {
        this.mailingCategoryService = mailingCategoryService;
        this.mailingCategoryMapper = mailingCategoryMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getMailingCategories() {
        List<MailingCategory> mailingCategories = mailingCategoryService.getMailingCategories();
        ResponseBody responseBody = new SuccessfulResponseBody<>(mailingCategoryMapper.mapCollection(mailingCategories));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
