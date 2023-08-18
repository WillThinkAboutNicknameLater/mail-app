package com.mailapp.mailservice.dto.response.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessfulResponseBody<T> extends ResponseBody {
    private T data;

    public SuccessfulResponseBody() {
        this(null);
    }

    public SuccessfulResponseBody(T data) {
        super(true);
        this.data = data;
    }
}
