package com.example.demo.controller;

import com.example.demo.model.FavoriteRestaurant;
import com.example.demo.service.inter.IFavoriteRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    @GetMapping("/favoriteRestaurant/{id_c}/{id_r}")
    public FavoriteRestaurant findByaIdr(@PathVariable Long id_c,@PathVariable Long id_r)
    {
        return favoriteRestaurantService.findByIdr(id_c,id_r);
    }
    @GetMapping("/favoriteRestaurant/{id_c}")
    public List<FavoriteRestaurant> findByaIdc(@PathVariable Long id_c)
    {
        return favoriteRestaurantService.findByIdc(id_c);
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

    @DeleteMapping("/favoriteRestaurants/delete/{favorie}")
    @ResponseStatus(value = HttpStatus.OK, reason = "favoriteRestaurant deleted successfully")
    public void deleteFavoriteRestaurant(@PathVariable FavoriteRestaurant favoriteRestaurant)
    {
        favoriteRestaurantService.delete(favoriteRestaurant);
    }

    @DeleteMapping("/favoriteRestaurants/delete/{id_c}/{id_r}")
    @ResponseStatus(value = HttpStatus.OK, reason = "favoriteRestaurant deleted successfully")
    public void deleteByIdr(@PathVariable Long id_c,@PathVariable Long id_r)
    {
        favoriteRestaurantService.deleteByIdr(id_c,id_r);
    }
}