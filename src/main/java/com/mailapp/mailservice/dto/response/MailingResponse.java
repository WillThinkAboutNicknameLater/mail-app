package com.mailapp.mailservice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class MailingResponse {
    @NotNull
    private UUID id;

    @NotNull
    private MailingCategoryResponse mailingCategory;

    @NotNull
    private String recipientName;

    @NotNull
    private String recipientZipCode;

    @NotNull
    private String recipientAddress;
}
