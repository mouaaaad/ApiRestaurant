package com.example.demo.service.inter;

import com.example.demo.model.MealCategory;

import java.util.List;

public interface IMealCategoryService
{
    public List<MealCategory> findAll();
    public MealCategory findById(Long id);
    MealCategory save(MealCategory mealCategory);
    void delete(MealCategory mealCategory);
}
