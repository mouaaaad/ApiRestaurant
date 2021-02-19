package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Client;
import com.example.demo.model.FavoriteRestaurant;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.FavoriteRestaurantRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavoriteRestaurantRestControllerTest
{
    @Autowired
    IAppInitService appInitService;

    @Autowired
    FavoriteRestaurantRestController favoriteRestaurantRestController;

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(favoriteRestaurantRepository.count(), favoriteRestaurantRestController.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(favoriteRestaurantRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(favoriteRestaurantRepository.findById(1L).get().getId(), favoriteRestaurantRestController.findById(1L).getId())
        );
    }
}