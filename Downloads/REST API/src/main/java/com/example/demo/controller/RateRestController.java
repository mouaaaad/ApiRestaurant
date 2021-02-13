package com.example.demo.controller;

import com.example.demo.model.Rate;
import com.example.demo.service.inter.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RateRestController
{
    @Autowired
    IRateService rateService;

    @GetMapping("/rates")
    public List<Rate> findAll()
    {
        return rateService.findAll();
    }

    @GetMapping("/rates/{id}")
    public Rate findById(@PathVariable Long id)
    {
        return rateService.findById(id);
    }

    @PostMapping("/rates/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Rate newRate(@RequestBody Rate rate)
    {
        return rateService.save(rate);
    }

    @PutMapping("/rates/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "rate updated successfully")
    public Rate editRate(@RequestBody Rate rate)
    {
        return rateService.save(rate);
    }

    @DeleteMapping("/rates/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "rate deleted successfully")
    public void deleteRate(@RequestBody Rate rate)
    {
        rateService.delete(rate);
    }
}