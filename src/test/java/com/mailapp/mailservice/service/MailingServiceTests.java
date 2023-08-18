package com.mailapp.mailservice.service;

import com.mailapp.mailservice.dto.request.AddNewMailingRequest;
import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.Mailing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class MailingServiceTests {
    @Autowired
    private MailingService mailingService;

    @Test
    void testGetMailingsIsNotEmpty() {
        Page<Mailing> mailings = mailingService.getMailings(PageRequest.ofSize(20));
        Assertions.assertFalse(mailings.isEmpty());
    }

    @Test
    void testGetMailingDoesNotThrow() {
        UUID existingMailingId = UUID.fromString("4ce8fd5d-41a3-48be-8fc4-116c0e42deee");
        Assertions.assertDoesNotThrow(() -> mailingService.getMailing(existingMailingId));
    }

    @Test
    void testGetMailingCategoryThrows() {
        UUID randomId = UUID.randomUUID();
        Assertions.assertThrows(NotFoundException.class, () -> mailingService.getMailing(randomId));
    }

    @Test
    void testAddNewMailingThrows() {
        AddNewMailingRequest newMailingRequest = AddNewMailingRequest.builder()
                                                                     .mailingCategoryId(100)
                                                                     .recipientName("Имя")
                                                                     .recipientAddress("Адрес")
                                                                     .recipientZipCode("192012")
                                                                     .build();

        Assertions.assertThrows(NotFoundException.class, () -> mailingService.addNewMailing(newMailingRequest));
    }
}
