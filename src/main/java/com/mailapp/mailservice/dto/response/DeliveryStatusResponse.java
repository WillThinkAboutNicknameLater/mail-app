package com.mailapp.mailservice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeliveryStatusResponse {
    @NotNull
    private Integer id;

    @NotNull
    private String name;
}
