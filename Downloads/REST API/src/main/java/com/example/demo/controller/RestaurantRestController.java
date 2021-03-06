package com.example.demo.controller;

import com.example.demo.model.FavoriteRestaurant;
import com.example.demo.model.Restaurant;
import com.example.demo.service.inter.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantRestController
{
    @Autowired
    IRestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> findAll()
    {
        return restaurantService.findAll();
    }


    @GetMapping("/restaurants/{id}")
    public Restaurant findById(@PathVariable Long id)
    {
        return restaurantService.findById(id);
    }

    @GetMapping("/restaurants/actualite")
    public List<Restaurant> findByActualite()
    {
        return restaurantService.findByActualite();
    }

    @GetMapping("/restaurant/{email}")
    public List<Restaurant> findByManager(@PathVariable String email)
    {
        return restaurantService.findByManager(email);
    }

    @GetMapping("/restaurant/name/{name}")
    public Restaurant findByName(@PathVariable String name)
    {
        return restaurantService.findByName(name);
    }

    @PostMapping("/restaurants/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant newRestaurant(@RequestBody Restaurant restaurant)
    {
        return restaurantService.save(restaurant);
    }

    @PutMapping("/restaurants/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "restaurant updated successfully")
    public Restaurant editRestaurant(@RequestBody Restaurant restaurant)
    {
        return restaurantService.save(restaurant);
    }

    @DeleteMapping("/restaurants/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "restaurant deleted successfully")
    public void deleteRestaurant(@RequestBody Restaurant restaurant)
    {
        restaurantService.delete(restaurant);
    }


    @DeleteMapping("/restaurants/delete/{name}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Restaurant deleted successfully")
    public void deletebyname(@PathVariable String name)
    {
        restaurantService.deletebyname(name);
    }
}
