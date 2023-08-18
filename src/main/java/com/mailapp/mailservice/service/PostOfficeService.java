package com.mailapp.mailservice.service;

import com.mailapp.mailservice.dto.request.AddNewPostOfficeRequest;
import com.mailapp.mailservice.exception.ConflictException;
import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.PostOffice;
import com.mailapp.mailservice.storage.repository.PostOfficeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public PostOfficeService(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    public PostOffice getPostOffice(UUID postOfficeId) {
        return postOfficeRepository.findPostOfficeById(postOfficeId)
                                   .orElseThrow(() -> new NotFoundException("Не удалось найти почтовое отделение по заданному ID"));
    }

    public Page<PostOffice> getPostOfficesByName(String searchName, Pageable pageable) {
        return postOfficeRepository.findAllByNameContainingIgnoreCaseOrderByName(searchName, pageable);
    }

    public PostOffice addNewPostOffice(AddNewPostOfficeRequest newPostOfficeInfo) {
        Optional<PostOffice> possibleCopy = postOfficeRepository.findPostOfficeByNameIgnoreCase(newPostOfficeInfo.getName());
        if (possibleCopy.isPresent() && possibleCopy.get().getZipCode().equals(newPostOfficeInfo.getZipCode())) {
            throw new ConflictException("Данное почтовое отделение уже есть в базе");
        }

        PostOffice newPostOffice = PostOffice.builder()
                                             .name(newPostOfficeInfo.getName())
                                             .zipCode(newPostOfficeInfo.getZipCode())
                                             .build();

        return postOfficeRepository.save(newPostOffice);
    }
}
