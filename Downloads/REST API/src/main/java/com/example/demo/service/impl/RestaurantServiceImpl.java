package com.example.demo.service.impl;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.inter.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantServiceImpl implements IRestaurantService
{
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll()
    {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(Long id)
    {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public Restaurant save(Restaurant restaurant)
    {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Restaurant restaurant)
    {
        restaurantRepository.delete(restaurant);
    }

    @Override
    public Restaurant findByManager(String email) {
        return restaurantRepository.findByManager(email);
    }

}
