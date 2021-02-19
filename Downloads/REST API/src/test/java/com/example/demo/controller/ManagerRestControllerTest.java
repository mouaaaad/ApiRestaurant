package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRestControllerTest
{
    @Autowired
    IAppInitService appInitService;

    @Autowired
    ManagerRestController managerRestController;

    @Autowired
    ManagerRepository managerRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(managerRepository.count(), managerRestController.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(managerRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(managerRepository.findById(2L).get().getId(), managerRestController.findById(2L).getId()),
                () -> assertEquals(managerRepository.findById(2L).get().getUsername(), managerRestController.findById(2L).getUsername()),
                () -> assertEquals(managerRepository.findById(2L).get().getPassword(), managerRestController.findById(2L).getPassword())
        );
    }

    @Test
    void findByEmail()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(managerRepository.findByEmail("hamza@email.com").getId(), managerRestController.findByEmail("hamza@email.com").getId()),
                () -> assertEquals(managerRepository.findByEmail("hamza@email.com").getUsername(), managerRestController.findByEmail("hamza@email.com").getUsername()),
                () -> assertEquals(managerRepository.findByEmail("hamza@email.com").getPassword(), managerRestController.findByEmail("hamza@email.com").getPassword())
        );
    }

    @Test
    void newManager()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Manager manager = new Manager();
        manager.setUsername("Bounasseh");
        assertEquals(manager.getUsername(), managerRestController.newClient(manager).getUsername());
    }

    @Test
    void editManager()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Manager manager = new Manager();
        manager.setId(2L);
        manager.setUsername("Bounasseh");
        assertEquals(manager.getUsername(), managerRestController.editClient(manager).getUsername());
    }
}