package com.mailapp.mailservice.mapper;

import com.mailapp.mailservice.dto.response.MailingStatusResponse;
import com.mailapp.mailservice.storage.model.MailingStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailingStatusMapper extends ClassMapper<MailingStatus, MailingStatusResponse> {
}