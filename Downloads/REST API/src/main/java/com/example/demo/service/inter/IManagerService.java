package com.example.demo.service.inter;

import com.example.demo.model.Manager;

import java.util.List;

public interface IManagerService
{
    public List<Manager> findAll();
    public Manager findById(Long id);

    Manager save(Manager manager);

    void delete(Manager manager);

    Manager findByEmail(String email);
}
