package com.mailapp.mailservice.mapper;

import com.mailapp.mailservice.dto.response.PostOfficeResponse;
import com.mailapp.mailservice.storage.model.PostOffice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostOfficeMapper extends ClassMapper<PostOffice, PostOfficeResponse> {
}
