package com.mailapp.mailservice.mapper;

import com.mailapp.mailservice.dto.response.MailingResponse;
import com.mailapp.mailservice.storage.model.Mailing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailingMapper extends ClassMapper<Mailing, MailingResponse> {
}