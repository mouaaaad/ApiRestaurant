package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.model.RestaurantCategory;
import com.example.demo.repository.MealCategoryRepository;
import com.example.demo.repository.RestaurantCategoryRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantCategoryRestControllerTest
{

    @Autowired
    IAppInitService appInitService;

    @Autowired
    RestaurantCategoryRestController restaurantCategoryRestController;

    @Autowired
    RestaurantCategoryRepository restaurantCategoryRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(restaurantCategoryRepository.count(), restaurantCategoryRestController.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(restaurantCategoryRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(restaurantCategoryRepository.findById(1L).get().getId(), restaurantCategoryRestController.findById(1L).getId()),
                () -> assertEquals(restaurantCategoryRepository.findById(1L).get().getCategory(), restaurantCategoryRestController.findById(1L).getCategory())
        );
    }

    @Test
    void newRestaurantCategory()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        RestaurantCategory restaurantCategory = new RestaurantCategory();
        restaurantCategory.setCategory("Marocain");
        assertEquals(restaurantCategory.getCategory(), restaurantCategoryRestController.newRestaurantCategory(restaurantCategory).getCategory());
    }

    @Test
    void editRestaurantCategory()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        RestaurantCategory restaurantCategory = new RestaurantCategory();
        restaurantCategory.setId(1L);
        restaurantCategory.setCategory("Marocain");
        assertEquals(restaurantCategory.getCategory(), restaurantCategoryRestController.editRestaurantCategory(restaurantCategory).getCategory());
    }
}