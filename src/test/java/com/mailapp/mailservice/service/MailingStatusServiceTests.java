package com.mailapp.mailservice.service;

import com.mailapp.mailservice.dto.request.AddNewMailingStatusRequest;
import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.MailingStatus;
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
class MailingStatusServiceTests {
    @Autowired
    private MailingStatusService mailingStatusService;

    @Test
    void testGetMailingStatusesIsNotEmpty() {
        UUID existingMailingId = UUID.fromString("4ce8fd5d-41a3-48be-8fc4-116c0e42deee");
        Page<MailingStatus> mailingStatuses = mailingStatusService.getMailingStatuses(existingMailingId, PageRequest.ofSize(20));
        Assertions.assertFalse(mailingStatuses.isEmpty());
    }

    @Test
    void testAddNewMailingStatusDoesNotThrow() {
        UUID existingMailingId = UUID.fromString("4ce8fd5d-41a3-48be-8fc4-116c0e42deee");
        AddNewMailingStatusRequest newMailingStatusRequest = AddNewMailingStatusRequest.builder()
                                                                                       .postOfficeId(UUID.fromString(
                                                                                               "9c6c755b-6076-4bb8-a903-3f87d1a3bf27"))
                                                                                       .deliveryStatusId(1)
                                                                                       .build();

        Assertions.assertDoesNotThrow(() -> mailingStatusService.addNewMailingStatus(existingMailingId, newMailingStatusRequest));
    }

    @Test
    void testAddNewMailingStatusThrows() {
        AddNewMailingStatusRequest newMailingStatusRequest = AddNewMailingStatusRequest.builder()
                                                                                       .postOfficeId(UUID.randomUUID())
                                                                                       .deliveryStatusId(100)
                                                                                       .build();

        Assertions.assertThrows(NotFoundException.class, () -> mailingStatusService.addNewMailingStatus(UUID.randomUUID(), newMailingStatusRequest));
    }
}
