package com.example.demo.service.impl;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.inter.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements IManagerService
{
    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<Manager> findAll()
    {
        return managerRepository.findAll();
    }

    @Override
    public Manager findById(Long id)
    {
        return managerRepository.findById(id).get();
    }

    @Override
    public Manager save(Manager manager)
    {
        return managerRepository.save(manager);
    }

    @Override
    public void delete(Manager manager)
    {
        managerRepository.delete(manager);
    }
}