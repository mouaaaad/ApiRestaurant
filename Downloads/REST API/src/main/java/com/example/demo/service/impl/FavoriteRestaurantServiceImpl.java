package com.example.demo.service.impl;

import com.example.demo.model.FavoriteRestaurant;
import com.example.demo.repository.FavoriteRestaurantRepository;
import com.example.demo.service.inter.IFavoriteRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FavoriteRestaurantServiceImpl implements IFavoriteRestaurantService
{
    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Override
    public List<FavoriteRestaurant> findAll()
    {
        return favoriteRestaurantRepository.findAll();
    }

    @Override
    public FavoriteRestaurant findById(Long id)
    {
        return favoriteRestaurantRepository.findById(id).get();
    }

    @Override
    public FavoriteRestaurant save(FavoriteRestaurant favoriteRestaurant)
    {
        return favoriteRestaurantRepository.save(favoriteRestaurant);
    }

    @Override
    public void delete(FavoriteRestaurant favoriteRestaurant)
    {
        favoriteRestaurantRepository.delete(favoriteRestaurant);
    }
}