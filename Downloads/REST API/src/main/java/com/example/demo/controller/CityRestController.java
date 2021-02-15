package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.inter.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CityRestController
{
    @Autowired
    ICityService cityService;

    @GetMapping("/cities")
    public List<City> findAll()
    {
        return cityService.findAll();
    }

    @GetMapping("/cities/{id}")
    public City findById(@PathVariable Long id)
    {
        return cityService.findById(id);
    }
    @GetMapping("/citie/{city}")
    public City findBycity(@PathVariable String city)
    {
        return cityService.findBycity(city);
    }

    @PostMapping("/cities/new")
    @ResponseStatus(HttpStatus.CREATED)
    public City newCity(@RequestBody City city)
    {
        return cityService.save(city);
    }

    @PutMapping("/cities/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "city updated successfully")
    public City editCity(@RequestBody City city)
    {
        return cityService.save(city);
    }

    @DeleteMapping("/cities/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "city deleted successfully")
    public void deleteCity(@RequestBody City city)
    {
        cityService.delete(city);
    }
}