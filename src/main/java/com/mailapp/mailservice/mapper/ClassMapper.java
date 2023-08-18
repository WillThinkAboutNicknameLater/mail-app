package com.mailapp.mailservice.mapper;

import com.mailapp.mailservice.dto.response.common.PageResponse;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface ClassMapper<S, T> {
    T map(S source);

    Collection<T> mapCollection(Collection<S> sourceCollection);

    default PageResponse<T> mapPage(Page<S> sourcePage) {
        Page<T> dtoPage = sourcePage.map(this::map);
        return PageResponse.of(dtoPage);
    }
}