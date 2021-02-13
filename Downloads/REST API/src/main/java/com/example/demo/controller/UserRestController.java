package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.User;
import com.example.demo.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController
{
    @Autowired
    IUserService userService;

    @GetMapping("/users")
    public List<User> findAll()
    {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id)
    {
        return userService.findById(id);
    }

   /* @RequestMapping(value = "/users", params="email, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE")
    public User findById(@RequestParam("email") String email)
    {
        return userService.findByEmail(email);
    }  */
   @GetMapping("/users/{email}")
   public User findById(@RequestParam("email") String email)
    {
        System.out.println(userService.findByEmail(email).getEmail());
       return userService.findByEmail(email);
    }

    // ATTENTION, On peut pas appliquer ces méthodes directement sur la classe "User" car il s'agit d'une classe abstraite.
    // IL FAUT PASSER plûtot par les controleur associer au classes "CLIENT" & "MANAGER"

    @PostMapping("/users/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user)
    {
        return userService.save(user);
    }

    @PutMapping("/users/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "user updated successfully")
    public User editUser(@RequestBody User user)
    {
        return userService.save(user);
    }

    @DeleteMapping("/users/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "user deleted successfully")
    public void deleteUser(@RequestBody User user)
    {
        userService.delete(user);
    }
}