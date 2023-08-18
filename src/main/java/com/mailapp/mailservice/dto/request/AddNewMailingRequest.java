package com.mailapp.mailservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddNewMailingRequest {
    @NotNull(message = "Не указан ID категории посылки")
    private Integer mailingCategoryId;

    @NotBlank(message = "Имя получателя не может быть пустым")
    private String recipientName;

    @NotNull(message = "Не указан почтовый индекс получателя")
    @Pattern(regexp = "\\d{6}", message = "Некорректный почтовый индекс")
    private String recipientZipCode;

    @NotBlank(message = "Адрес получателя не может быть пустым")
    private String recipientAddress;
}
