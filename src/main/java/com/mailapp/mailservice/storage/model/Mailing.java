package com.mailapp.mailservice.storage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mailings")
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mailing_category_id", nullable = false)
    private MailingCategory mailingCategory;

    @NotNull
    @Column(name = "recipient_name", nullable = false, length = Integer.MAX_VALUE)
    private String recipientName;

    @Size(max = 6)
    @NotNull
    @Column(name = "recipient_zip_code", nullable = false, length = 6)
    private String recipientZipCode;

    @NotNull
    @Column(name = "recipient_address", nullable = false, length = Integer.MAX_VALUE)
    private String recipientAddress;

    @Builder.Default
    @OneToMany(mappedBy = "mailing")
    private Set<MailingStatus> mailingStatuses = new LinkedHashSet<>();
}