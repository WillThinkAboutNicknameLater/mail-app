package com.mailapp.mailservice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class PostOfficeResponse {
    @NotNull
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String zipCode;
}
