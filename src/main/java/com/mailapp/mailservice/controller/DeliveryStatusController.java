package com.mailapp.mailservice.controller;

import com.mailapp.mailservice.dto.response.common.ResponseBody;
import com.mailapp.mailservice.dto.response.common.SuccessfulResponseBody;
import com.mailapp.mailservice.mapper.DeliveryStatusMapper;
import com.mailapp.mailservice.service.DeliveryStatusService;
import com.mailapp.mailservice.storage.model.DeliveryStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/delivery-statuses")
@RestController
public class DeliveryStatusController {
    private final DeliveryStatusService deliveryStatusService;

    private final DeliveryStatusMapper deliveryStatusMapper;

    public DeliveryStatusController(DeliveryStatusService deliveryStatusService, DeliveryStatusMapper deliveryStatusMapper) {
        this.deliveryStatusService = deliveryStatusService;
        this.deliveryStatusMapper = deliveryStatusMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getDeliveryStatuses() {
        List<DeliveryStatus> deliveryStatuses = deliveryStatusService.getDeliveryStatuses();
        ResponseBody responseBody = new SuccessfulResponseBody<>(deliveryStatusMapper.mapCollection(deliveryStatuses));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
