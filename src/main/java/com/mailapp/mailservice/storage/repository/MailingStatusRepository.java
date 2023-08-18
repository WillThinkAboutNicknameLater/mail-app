package com.mailapp.mailservice.storage.repository;

import com.mailapp.mailservice.storage.model.MailingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MailingStatusRepository extends JpaRepository<MailingStatus, UUID> {
    Page<MailingStatus> findAllByMailingIdOrderByAddedAtDesc(UUID mailingId, Pageable pageable);
}