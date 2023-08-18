package com.mailapp.mailservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddNewPostOfficeRequest {
    @NotBlank(message = "Название почтового отделения не может быть пустым")
    private String name;

    @NotNull(message = "Не указан почтовый индекс")
    @Pattern(regexp = "\\d{6}", message = "Некорректный почтовый индекс")
    private String zipCode;
}
