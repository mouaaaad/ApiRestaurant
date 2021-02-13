package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.inter.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClientRestController
{
    @Autowired
    IClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAll()
    {
        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable Long id)
    {
        return clientService.findById(id);
    }

    @PostMapping("/clients/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Client newClient(@RequestBody Client client)
    {
        return clientService.save(client);
    }

    @PutMapping("/clients/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "client updated successfully")
    public Client editClient(@RequestBody Client client)
    {
        return clientService.save(client);
    }

    @DeleteMapping("/clients/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "client deleted successfully")
    public void deleteClient(@RequestBody Client client)
    {
        clientService.delete(client);
    }
}