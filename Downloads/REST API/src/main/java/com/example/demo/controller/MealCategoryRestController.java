package com.example.demo.controller;

import com.example.demo.model.MealCategory;
import com.example.demo.service.inter.IMealCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MealCategoryRestController
{
    @Autowired
    IMealCategoryService mealCategoryService;

    @GetMapping("/mealCategories")
    public List<MealCategory> findAll()
    {
        return mealCategoryService.findAll();
    }

    @GetMapping("/mealCategories/{id}")
    public MealCategory findById(@PathVariable Long id)
    {
        return mealCategoryService.findById(id);
    }

    @PostMapping("/mealCategories/new")
    @ResponseStatus(HttpStatus.CREATED)
    public MealCategory newMealCategory(@RequestBody MealCategory mealCategory)
    {
        return mealCategoryService.save(mealCategory);
    }

    @PutMapping("/mealCategories/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "mealCategory updated successfully")
    public MealCategory editMealCategory(@RequestBody MealCategory mealCategory)
    {
        return mealCategoryService.save(mealCategory);
    }

    @DeleteMapping("/mealCategories/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "mealCategory deleted successfully")
    public void deleteMealCategory(@RequestBody MealCategory mealCategory)
    {
        mealCategoryService.delete(mealCategory);
    }
}
