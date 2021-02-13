package com.example.demo.service.impl;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.inter.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements ICityService
{
    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll()
    {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id)
    {
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(City city)
    {
        return cityRepository.save(city);
    }

    @Override
    public void delete(City city)
    {
        cityRepository.delete(city);
    }
}