package com.example.demo.service.inter;

import com.example.demo.model.RestaurantCategory;

import java.util.List;

public interface IRestaurantCategoryService
{
    public List<RestaurantCategory> findAll();
    public RestaurantCategory findById(Long id);

    RestaurantCategory save(RestaurantCategory restaurantCategory);

    void delete(RestaurantCategory restaurantCategory);

    RestaurantCategory findBycategory(String category);
}