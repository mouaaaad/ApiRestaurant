package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.MealRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantRestControllerTest
{
    // Restaurant
    // restaurant
    
    @Autowired
    IAppInitService appInitService;

    @Autowired
    RestaurantRestController restaurantRestController;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(restaurantRepository.count(), restaurantRepository.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(restaurantRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(restaurantRepository.findById(1L).get().getId(), restaurantRestController.findById(1L).getId()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getName(), restaurantRestController.findById(1L).getName()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getPicture(), restaurantRestController.findById(1L).getPicture()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getPhone(), restaurantRestController.findById(1L).getPhone()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getLatitude(), restaurantRestController.findById(1L).getLatitude()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getLongitude(), restaurantRestController.findById(1L).getLongitude()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getCreatedAt(), restaurantRestController.findById(1L).getCreatedAt()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getOpeningTime(), restaurantRestController.findById(1L).getOpeningTime()),
                () -> assertEquals(restaurantRepository.findById(1L).get().getClosingTime(), restaurantRestController.findById(1L).getClosingTime())
        );
    }

    @Test
    void newRestaurant()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Buvette ENSAK");
        assertEquals(restaurant.getName(), restaurantRestController.newRestaurant(restaurant).getName());
    }

    @Test
    void editRestaurant()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);
        restaurant.setName("Buvette ENSAK");
        assertEquals(restaurant.getName(), restaurantRestController.editRestaurant(restaurant).getName());
    }
}