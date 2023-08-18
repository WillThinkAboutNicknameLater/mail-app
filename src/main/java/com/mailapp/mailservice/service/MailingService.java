package com.mailapp.mailservice.service;

import com.mailapp.mailservice.dto.request.AddNewMailingRequest;
import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.Mailing;
import com.mailapp.mailservice.storage.model.MailingCategory;
import com.mailapp.mailservice.storage.repository.MailingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MailingService {
    private final MailingRepository mailingRepository;

    private final MailingCategoryService mailingCategoryService;

    public MailingService(MailingRepository mailingRepository, MailingCategoryService mailingCategoryService) {
        this.mailingRepository = mailingRepository;
        this.mailingCategoryService = mailingCategoryService;
    }

    public Page<Mailing> getMailings(Pageable pageable) {
        return mailingRepository.findAll(pageable);
    }

    public Mailing getMailing(UUID mailingId) {
        return mailingRepository.findMailingById(mailingId)
                                .orElseThrow(() -> new NotFoundException("Не удалось найти почтовое отправление по заданному ID"));
    }

    public Mailing addNewMailing(AddNewMailingRequest newMailingInfo) {
        MailingCategory mailingCategory = mailingCategoryService.getMailingCategory(newMailingInfo.getMailingCategoryId());

        Mailing newMailing = Mailing.builder()
                                    .mailingCategory(mailingCategory)
                                    .recipientName(newMailingInfo.getRecipientName())
                                    .recipientZipCode(newMailingInfo.getRecipientZipCode())
                                    .recipientAddress(newMailingInfo.getRecipientAddress())
                                    .build();

        return mailingRepository.save(newMailing);
    }
}
