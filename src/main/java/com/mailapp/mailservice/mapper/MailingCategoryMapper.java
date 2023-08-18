package com.mailapp.mailservice.mapper;

import com.mailapp.mailservice.dto.response.MailingCategoryResponse;
import com.mailapp.mailservice.storage.model.MailingCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailingCategoryMapper extends ClassMapper<MailingCategory, MailingCategoryResponse> {
}
