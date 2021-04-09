package com.example.librarymanagement.service;

import com.example.librarymanagement.Entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<Users> findAll();

    public Optional<Users> findById(int theId);

    public void save(Users theuser);

    public void deleteById(int theId);
}
