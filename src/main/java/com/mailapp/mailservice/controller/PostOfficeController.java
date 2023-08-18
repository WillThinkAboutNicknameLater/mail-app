package com.mailapp.mailservice.controller;

import com.mailapp.mailservice.dto.request.AddNewPostOfficeRequest;
import com.mailapp.mailservice.dto.response.common.ResponseBody;
import com.mailapp.mailservice.dto.response.common.SuccessfulResponseBody;
import com.mailapp.mailservice.mapper.PostOfficeMapper;
import com.mailapp.mailservice.service.PostOfficeService;
import com.mailapp.mailservice.storage.model.PostOffice;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post-offices")
@RestController
public class PostOfficeController {
    private final PostOfficeService postOfficeService;

    private final PostOfficeMapper postOfficeMapper;

    public PostOfficeController(PostOfficeService postOfficeService, PostOfficeMapper postOfficeMapper) {
        this.postOfficeService = postOfficeService;
        this.postOfficeMapper = postOfficeMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getPostOffices(@RequestParam(value = "name", defaultValue = "") String searchName, Pageable pageable) {
        Page<PostOffice> postOffices = postOfficeService.getPostOfficesByName(searchName, pageable);
        ResponseBody responseBody = new SuccessfulResponseBody<>(postOfficeMapper.mapPage(postOffices));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> addNewPostOffice(@RequestBody @Valid AddNewPostOfficeRequest request) {
        PostOffice newPostOffice = postOfficeService.addNewPostOffice(request);
        ResponseBody responseBody = new SuccessfulResponseBody<>(postOfficeMapper.map(newPostOffice));
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }
}
