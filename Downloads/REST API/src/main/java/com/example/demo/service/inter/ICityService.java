package com.example.demo.service.inter;

import com.example.demo.model.City;

import java.util.List;


public interface ICityService
{
    List<City> findAll();
    City findById(Long id);
    City save(City city);
    void delete(City city);

    City findBycity(String city);
}