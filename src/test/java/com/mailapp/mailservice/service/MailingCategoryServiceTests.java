package com.mailapp.mailservice.service;

import com.mailapp.mailservice.exception.NotFoundException;
import com.mailapp.mailservice.storage.model.MailingCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MailingCategoryServiceTests {
    @Autowired
    private MailingCategoryService mailingCategoryService;

    @Test
    void testGetMailingCategoriesIsNotEmpty() {
        List<MailingCategory> mailingCategories = mailingCategoryService.getMailingCategories();
        Assertions.assertFalse(mailingCategories.isEmpty());
    }

    @Test
    void testGetMailingCategoryDoesNotThrow() {
        Assertions.assertDoesNotThrow(() -> mailingCategoryService.getMailingCategory(1));
    }

    @Test
    void testGetMailingCategoryThrows() {
        Assertions.assertThrows(NotFoundException.class, () -> mailingCategoryService.getMailingCategory(100));
    }
}
