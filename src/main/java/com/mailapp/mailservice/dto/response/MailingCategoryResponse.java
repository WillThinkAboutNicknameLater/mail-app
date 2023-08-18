package com.mailapp.mailservice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MailingCategoryResponse {
    @NotNull
    private Integer id;

    @NotNull
    private String name;
}
