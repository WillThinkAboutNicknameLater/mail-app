package com.mailapp.mailservice.service;

import com.mailapp.mailservice.dto.request.AddNewMailingStatusRequest;
import com.mailapp.mailservice.storage.model.DeliveryStatus;
import com.mailapp.mailservice.storage.model.Mailing;
import com.mailapp.mailservice.storage.model.MailingStatus;
import com.mailapp.mailservice.storage.model.PostOffice;
import com.mailapp.mailservice.storage.repository.MailingStatusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MailingStatusService {
    private final MailingStatusRepository mailingStatusRepository;

    private final MailingService mailingService;

    private final PostOfficeService postOfficeService;

    private final DeliveryStatusService deliveryStatusService;

    public MailingStatusService(MailingStatusRepository mailingStatusRepository,
                                MailingService mailingService,
                                PostOfficeService postOfficeService,
                                DeliveryStatusService deliveryStatusService) {
        this.mailingStatusRepository = mailingStatusRepository;
        this.mailingService = mailingService;
        this.postOfficeService = postOfficeService;
        this.deliveryStatusService = deliveryStatusService;
    }

    public Page<MailingStatus> getMailingStatuses(UUID mailingId, Pageable pageable) {
        return mailingStatusRepository.findAllByMailingIdOrderByAddedAtDesc(mailingId, pageable);
    }

    public MailingStatus addNewMailingStatus(UUID mailingId, AddNewMailingStatusRequest newMailingStatusInfo) {
        Mailing mailing = mailingService.getMailing(mailingId);
        PostOffice postOffice = postOfficeService.getPostOffice(newMailingStatusInfo.getPostOfficeId());
        DeliveryStatus deliveryStatus = deliveryStatusService.getDeliveryStatus(newMailingStatusInfo.getDeliveryStatusId());

        MailingStatus newMailingStatus = MailingStatus.builder()
                                                      .mailing(mailing)
                                                      .postOffice(postOffice)
                                                      .deliveryStatus(deliveryStatus)
                                                      .build();

        return mailingStatusRepository.save(newMailingStatus);
    }
}
