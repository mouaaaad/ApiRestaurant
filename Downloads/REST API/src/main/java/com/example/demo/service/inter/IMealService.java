package com.example.demo.service.inter;

import com.example.demo.model.Meal;

import java.util.List;

public interface IMealService
{
    public List<Meal> findAll();
    public Meal findById(Long id);
    Meal save(Meal meal);
    void delete(Meal meal);
}
