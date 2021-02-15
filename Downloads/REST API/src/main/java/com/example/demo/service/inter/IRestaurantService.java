package com.example.demo.service.inter;

import com.example.demo.model.Restaurant;

import java.util.List;

public interface IRestaurantService
{
    public List<Restaurant> findAll();
    public Restaurant findById(Long id);
    Restaurant save(Restaurant restaurant);
    void delete(Restaurant restaurant);

    List<Restaurant> findByManager(String email);

    Restaurant findByName(String name);

    void deletebyname(String name);

    List<Restaurant> findByActualite();
}
