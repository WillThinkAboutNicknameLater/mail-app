package com.mailapp.mailservice.service;

import com.mailapp.mailservice.dto.request.AddNewPostOfficeRequest;
import com.mailapp.mailservice.exception.ConflictException;
import com.mailapp.mailservice.storage.model.PostOffice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class PostOfficeServiceTests {
    @Autowired
    private PostOfficeService postOfficeService;

    @Test
    void testGetPostOfficesByNameIsNotEmpty() {
        Page<PostOffice> postOffices = postOfficeService.getPostOfficesByName("", PageRequest.ofSize(20));
        Assertions.assertFalse(postOffices.isEmpty());
    }

    @Test
    void testAddNewPostOfficeThrows() {
        AddNewPostOfficeRequest newPostOfficeRequest = AddNewPostOfficeRequest.builder()
                                                                              .name("Отделение №132")
                                                                              .zipCode("630132")
                                                                              .build();

        Assertions.assertThrows(ConflictException.class, () -> postOfficeService.addNewPostOffice(newPostOfficeRequest));
    }
}
