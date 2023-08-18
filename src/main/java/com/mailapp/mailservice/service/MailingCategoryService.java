package com.mailapp.mailservice.service;

import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.MailingCategory;
import com.mailapp.mailservice.storage.repository.MailingCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailingCategoryService {
    private final MailingCategoryRepository mailingCategoryRepository;

    public MailingCategoryService(MailingCategoryRepository mailingCategoryRepository) {
        this.mailingCategoryRepository = mailingCategoryRepository;
    }

    public List<MailingCategory> getMailingCategories() {
        return mailingCategoryRepository.findAll();
    }

    public MailingCategory getMailingCategory(Integer mailingCategoryId) {
        return mailingCategoryRepository.findMailingCategoryById(mailingCategoryId)
                                        .orElseThrow(() -> new NotFoundException("Не удалось найти категорию посылок по заданному ID"));
    }
}
