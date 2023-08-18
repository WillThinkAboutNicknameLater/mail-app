package com.mailapp.mailservice.dto.response.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UnsuccessfulResponseBody extends ResponseBody {
    private final Set<ErrorBody> errors;

    public UnsuccessfulResponseBody(Collection<ErrorBody> errors) {
        super(false);
        this.errors = new HashSet<>(errors);
    }

    public UnsuccessfulResponseBody(ErrorBody error) {
        this(List.of(error));
    }
}