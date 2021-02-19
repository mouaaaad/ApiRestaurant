package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.model.MealCategory;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.MealRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MealRestControllerTest
{
    @Autowired
    IAppInitService appInitService;

    @Autowired
    MealRestController mealRestController;

    @Autowired
    MealRepository mealRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(mealRepository.count(), mealRestController.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(mealRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(mealRepository.findById(1L).get().getId(), mealRestController.findById(1L).getId()),
                () -> assertEquals(mealRepository.findById(1L).get().getMeal(), mealRestController.findById(1L).getMeal()),
                () -> assertEquals(mealRepository.findById(1L).get().getPrice(), mealRestController.findById(1L).getPrice()),
                () -> assertEquals(mealRepository.findById(1L).get().getDetail(), mealRestController.findById(1L).getDetail())
        );
    }

    @Test
    void newMeal()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Meal meal = new Meal();
        meal.setMeal("Pizza");
        assertEquals(meal.getMeal(), mealRestController.newMeal(meal).getMeal());
    }

    @Test
    void editMeal()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Meal meal = new Meal();
        meal.setId(1L);
        meal.setMeal("Tacos");
        assertEquals(meal.getMeal(), mealRestController.editMeal(meal).getMeal());
    }
}