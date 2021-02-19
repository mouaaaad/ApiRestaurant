package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Client;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientRestControllerTest
{
    @Autowired
    IAppInitService appInitService;

    @Autowired
    ClientRestController clientRestController;

    @Autowired
    ClientRepository clientRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(clientRepository.count(), clientRestController.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(clientRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(clientRepository.findById(1L).get().getId(), clientRestController.findById(1L).getId()),
                () -> assertEquals(clientRepository.findById(1L).get().getUsername(), clientRestController.findById(1L).getUsername()),
                () -> assertEquals(clientRepository.findById(1L).get().getPassword(), clientRestController.findById(1L).getPassword())
        );
    }

    @Test
    void findByEmail()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(clientRepository.findByEmail("ayoub@email.com").getId(), clientRestController.findByEmail("ayoub@email.com").getId()),
                () -> assertEquals(clientRepository.findByEmail("ayoub@email.com").getUsername(), clientRestController.findByEmail("ayoub@email.com").getUsername()),
                () -> assertEquals(clientRepository.findByEmail("ayoub@email.com").getPassword(), clientRestController.findByEmail("ayoub@email.com").getPassword())
        );
    }

    @Test
    void newClient()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Client client = new Client();
        client.setUsername("Bounasseh");
        assertEquals(client.getUsername(), clientRestController.newClient(client).getUsername());
    }

    @Test
    void editClient()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Client client = new Client();
        client.setId(1L);
        client.setUsername("Bounasseh");
        assertEquals(client.getUsername(), clientRestController.editClient(client).getUsername());
    }
}