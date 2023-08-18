package com.mailapp.mailservice.service;

import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.DeliveryStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class DeliveryStatusServiceTests {
    @Autowired
    private DeliveryStatusService deliveryStatusService;

    @Test
    void testGetDeliveryStatusesIsNotEmpty() {
        List<DeliveryStatus> deliveryStatuses = deliveryStatusService.getDeliveryStatuses();
        Assertions.assertFalse(deliveryStatuses.isEmpty());
    }

    @Test
    void testGetDeliveryStatusDoesNotThrow() {
        Assertions.assertDoesNotThrow(() -> deliveryStatusService.getDeliveryStatus(1));
    }

    @Test
    void testGetDeliveryStatusThrows() {
        Assertions.assertThrows(NotFoundException.class, () -> deliveryStatusService.getDeliveryStatus(100));
    }
}
