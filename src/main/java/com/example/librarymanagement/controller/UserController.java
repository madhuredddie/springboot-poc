package com.example.librarymanagement.controller;

import com.example.librarymanagement.Entity.Books;
import com.example.librarymanagement.Entity.Users;
import com.example.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class UserController {

    private UserService theUserService;

    @Autowired
    public UserController(UserService theUserService) {
        this.theUserService = theUserService;
    }

    @GetMapping("/users")
    public List<Users> findall()
    {
        return theUserService.findAll();
    }

    @GetMapping("/users/{userId}")
    public Users getUser(@PathVariable int userId) {

        Users theuser = null;
        Optional<Users> result = theUserService.findById(userId);
        if (result.isPresent()) {
            theuser = result.get();
        } else {
            throw new RuntimeException(" user not found");
        }


        return theuser;
    }

    @PostMapping("/users")
    public Users addUser(@RequestBody   Users theuser) {

        theuser.setId(0);

        theUserService.save(theuser);

        return theuser;
    }

    @PutMapping("/users")
    public Users updateUser(@RequestBody Users theuser) {

        theUserService.save(theuser);

        return theuser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        Users theuser = null;
        Optional<Users> result = theUserService.findById(userId);
        if (result.isPresent()) {
            theuser = result.get();
        } else {
            throw new RuntimeException(" user not found");
        }

        theUserService.deleteById(userId);

        return "Deleted user id - " + userId;
    }
}
