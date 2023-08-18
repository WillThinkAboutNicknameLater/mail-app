package com.mailapp.mailservice.storage.repository;

import com.mailapp.mailservice.storage.model.MailingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MailingCategoryRepository extends JpaRepository<MailingCategory, Integer> {
    Optional<MailingCategory> findMailingCategoryById(Integer id);
}
