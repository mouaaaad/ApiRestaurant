package com.example.demo.service.inter;

import com.example.demo.model.City;
import com.example.demo.model.Client;
import com.example.demo.model.Manager;

import java.util.List;

public interface IClientService
{
    List<Client> findAll();
    Client findById(Long id);
    Client save(Client client);
    void delete(Client client);
}
