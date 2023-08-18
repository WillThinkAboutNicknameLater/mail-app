package com.mailapp.mailservice.storage.repository;

import com.mailapp.mailservice.storage.model.PostOffice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PostOfficeRepository extends JpaRepository<PostOffice, UUID> {
    Optional<PostOffice> findPostOfficeById(UUID id);

    Optional<PostOffice> findPostOfficeByNameIgnoreCase(String name);

    Page<PostOffice> findAllByNameContainingIgnoreCaseOrderByName(String searchName, Pageable pageable);
}
