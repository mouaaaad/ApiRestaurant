package com.example.demo.service.inter;

import com.example.demo.model.FavoriteRestaurant;

import java.util.List;

public interface IFavoriteRestaurantService
{
    public List<FavoriteRestaurant> findAll();
    public FavoriteRestaurant findById(Long id);
    FavoriteRestaurant save(FavoriteRestaurant favoriteRestaurant);
    void delete(FavoriteRestaurant favoriteRestaurant);
}
