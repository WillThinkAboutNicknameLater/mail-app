package com.mailapp.mailservice.storage.repository;

import com.mailapp.mailservice.storage.model.Mailing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MailingRepository extends JpaRepository<Mailing, UUID> {
    Optional<Mailing> findMailingById(UUID id);
}
