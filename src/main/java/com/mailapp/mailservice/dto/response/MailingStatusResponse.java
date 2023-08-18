package com.mailapp.mailservice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class MailingStatusResponse {
    @NotNull
    private UUID id;

    @NotNull
    private PostOfficeResponse postOffice;

    @NotNull
    private DeliveryStatusResponse deliveryStatus;

    @NotNull
    private OffsetDateTime addedAt;
}
