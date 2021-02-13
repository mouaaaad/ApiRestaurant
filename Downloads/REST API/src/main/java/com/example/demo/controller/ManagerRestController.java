package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Manager;
import com.example.demo.service.inter.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ManagerRestController
{
    @Autowired
    IManagerService managerService;

    @GetMapping("/managers")
    public List<Manager> findAll()
    {
        return managerService.findAll();
    }

    @GetMapping("/managers/{id}")
    public Manager findById(@PathVariable Long id)
    {
        return managerService.findById(id);
    }

    @PostMapping("/managers/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Manager newClient(@RequestBody Manager manager)
    {
        return managerService.save(manager);
    }

    @PutMapping("/managers/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "manager updated successfully")
    public Manager editClient(@RequestBody Manager manager)
    {
        return managerService.save(manager);
    }

    @DeleteMapping("/managers/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "manager deleted successfully")
    public void deleteClient(@RequestBody Manager manager)
    {
        managerService.delete(manager);
    }
}