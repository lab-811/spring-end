package org.example.Islambek.controller;

import org.example.Islambek.model.User;
import org.example.Islambek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/signUp")
    public void userRegistration(@RequestBody User user){

        userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        userService.updateUser(id, user);
    }


    @PatchMapping("/{id}")
    public void updateUsername(@PathVariable Long id,
                               @RequestParam String username){

        userService.updateUserName(id, username);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
}
