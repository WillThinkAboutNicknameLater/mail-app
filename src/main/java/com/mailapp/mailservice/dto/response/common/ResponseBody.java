package com.mailapp.mailservice.dto.response.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ResponseBody {
    protected boolean success;
}