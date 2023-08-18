package com.mailapp.mailservice.dto.response.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorBody {
    private String message;
}