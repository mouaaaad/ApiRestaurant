package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.inter.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements IClientService
{
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll()
    {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id)
    {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client save(Client client)
    {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Client client)
    {
        clientRepository.delete(client);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}