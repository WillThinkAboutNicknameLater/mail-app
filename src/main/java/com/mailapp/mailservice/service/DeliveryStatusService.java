package com.mailapp.mailservice.service;

import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.DeliveryStatus;
import com.mailapp.mailservice.storage.repository.DeliveryStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryStatusService {
    private final DeliveryStatusRepository deliveryStatusRepository;

    public DeliveryStatusService(DeliveryStatusRepository deliveryStatusRepository) {
        this.deliveryStatusRepository = deliveryStatusRepository;
    }

    public List<DeliveryStatus> getDeliveryStatuses() {
        return deliveryStatusRepository.findAll();
    }

    public DeliveryStatus getDeliveryStatus(Integer deliveryStatusId) {
        return deliveryStatusRepository.findDeliveryStatusById(deliveryStatusId)
                                       .orElseThrow(() -> new NotFoundException("Не удалось найти статус передвижения по заданному ID"));
    }
}
