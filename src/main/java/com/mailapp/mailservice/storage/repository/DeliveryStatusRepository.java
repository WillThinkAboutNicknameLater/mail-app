package com.mailapp.mailservice.storage.repository;

import com.mailapp.mailservice.storage.model.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus, Integer> {
    Optional<DeliveryStatus> findDeliveryStatusById(Integer id);
}