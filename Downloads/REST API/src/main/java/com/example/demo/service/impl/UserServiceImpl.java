package com.example.demo.service.impl;

import com.example.demo.model.City;
import com.example.demo.model.User;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id)
    {
        return userRepository.findById(id).get();
    }
    @Override
    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user)
    {
        userRepository.delete(user);
    }
}