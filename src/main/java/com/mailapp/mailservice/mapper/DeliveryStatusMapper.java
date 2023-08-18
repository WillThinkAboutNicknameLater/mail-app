package com.mailapp.mailservice.mapper;

import com.mailapp.mailservice.dto.response.DeliveryStatusResponse;
import com.mailapp.mailservice.storage.model.DeliveryStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryStatusMapper extends ClassMapper<DeliveryStatus, DeliveryStatusResponse> {
}