package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.service.inter.IMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MealRestController
{
    @Autowired
    IMealService mealService;

    @GetMapping("/meals")
    public List<Meal> findAll()
    {
        return mealService.findAll();
    }

    @GetMapping("/meal/{name}")
    public List<Meal> findByRestaurant(@PathVariable String name)
    {
        return mealService.findByRestaurant(name);
    }
    @GetMapping("/meals/{id}")
    public List<Meal> findMealsById(@PathVariable Long id)
    {
        return mealService.findMealsById(id);
    }
    @GetMapping("/mealss/{id}")
    public Meal findById(@PathVariable Long id)
    {
        return mealService.findById(id);
    }

    @PostMapping("/meals/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Meal newMeal(@RequestBody Meal meal)
    {
        return mealService.save(meal);
    }

    @PutMapping("/meals/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "meal updated successfully")
    public Meal editMeal(@RequestBody Meal meal)
    {
        return mealService.save(meal);
    }

    @DeleteMapping("/meals/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "meal deleted successfully")
    public void deleteMeal(@RequestBody Meal meal)
    {
        mealService.delete(meal);
    }

    @DeleteMapping("/meals/delete/{meal}")
    @ResponseStatus(value = HttpStatus.OK, reason = "meal deleted successfully")
    public void deletebymeal(@PathVariable String meal)
    {
        mealService.deletebymeal(meal);
    }
}