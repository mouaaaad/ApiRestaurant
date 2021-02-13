package com.example.demo.controller;

import com.example.demo.model.FavoriteRestaurant;
import com.example.demo.service.inter.IFavoriteRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteRestaurantRestController
{
    @Autowired
    IFavoriteRestaurantService favoriteRestaurantService;

    @GetMapping("/favoriteRestaurants")
    public List<FavoriteRestaurant> findAll()
    {
        return favoriteRestaurantService.findAll();
    }

    @GetMapping("/favoriteRestaurants/{id}")
    public FavoriteRestaurant findById(@PathVariable Long id)
    {
        return favoriteRestaurantService.findById(id);
    }

    @PostMapping("/favoriteRestaurants/new")
    @ResponseStatus(HttpStatus.CREATED)
    public FavoriteRestaurant newFavoriteRestaurant(@RequestBody FavoriteRestaurant favoriteRestaurant)
    {
        return favoriteRestaurantService.save(favoriteRestaurant);
    }

    @PutMapping("/favoriteRestaurants/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "favoriteRestaurant updated successfully")
    public FavoriteRestaurant editFavoriteRestaurant(@RequestBody FavoriteRestaurant favoriteRestaurant)
    {
        return favoriteRestaurantService.save(favoriteRestaurant);
    }

    @DeleteMapping("/favoriteRestaurants/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "favoriteRestaurant deleted successfully")
    public void deleteFavoriteRestaurant(@RequestBody FavoriteRestaurant favoriteRestaurant)
    {
        favoriteRestaurantService.delete(favoriteRestaurant);
    }
}