package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.RestaurantCategory;
import com.example.demo.service.inter.IRestaurantCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantCategoryRestController
{
    @Autowired
    IRestaurantCategoryService restaurantCategoryService;

    @GetMapping("/restaurantCategories")
    public List<RestaurantCategory> findAll()
    {
        return restaurantCategoryService.findAll();
    }

    @GetMapping("/restaurantCategories/{id}")
    public RestaurantCategory findById(@PathVariable Long id)
    {
        return restaurantCategoryService.findById(id);
    }

    @PostMapping("/restaurantCategories/new")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantCategory newRestaurantCategory(@RequestBody RestaurantCategory restaurantCategory)
    {
        return restaurantCategoryService.save(restaurantCategory);
    }

    @PutMapping("/restaurantCategories/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "restaurantCategory updated successfully")
    public RestaurantCategory editRestaurantCategory(@RequestBody RestaurantCategory restaurantCategory)
    {
        return restaurantCategoryService.save(restaurantCategory);
    }

    @DeleteMapping("/restaurantCategories/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "restaurantCategory deleted successfully")
    public void deleteRestaurantCategory(@RequestBody RestaurantCategory restaurantCategory)
    {
        restaurantCategoryService.delete(restaurantCategory);
    }
}