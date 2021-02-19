package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.MealCategory;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.MealCategoryRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MealCategoryRestControllerTest
{
    @Autowired
    IAppInitService appInitService;

    @Autowired
    MealCategoryRestController mealCategoryRestController;

    @Autowired
    MealCategoryRepository mealCategoryRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(mealCategoryRepository.count(), mealCategoryRestController.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(mealCategoryRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(mealCategoryRepository.findById(1L).get().getId(), mealCategoryRestController.findById(1L).getId()),
                () -> assertEquals(mealCategoryRepository.findById(1L).get().getCategory(), mealCategoryRestController.findById(1L).getCategory())
        );
    }

    @Test
    void newMealCategory()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        MealCategory mealCategory = new MealCategory();
        mealCategory.setCategory("Cuisine Marocaine");
        assertEquals(mealCategory.getCategory(), mealCategoryRestController.newMealCategory(mealCategory).getCategory());
    }

    @Test
    void editMealCategory()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        MealCategory mealCategory = new MealCategory();
        mealCategory.setId(1L);
        mealCategory.setCategory("Cuisine Italienne");
        assertEquals(mealCategory.getCategory(), mealCategoryRestController.editMealCategory(mealCategory).getCategory());
    }
}