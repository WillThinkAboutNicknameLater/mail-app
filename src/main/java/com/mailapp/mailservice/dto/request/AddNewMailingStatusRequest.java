package com.mailapp.mailservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class AddNewMailingStatusRequest {
    @NotNull(message = "Не указан ID почтового отделения")
    private UUID postOfficeId;

    @NotNull(message = "Не указан ID статуса передвижения")
    private Integer deliveryStatusId;
}
