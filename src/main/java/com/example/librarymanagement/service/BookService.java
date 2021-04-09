package com.example.librarymanagement.service;

import com.example.librarymanagement.Entity.Books;

import java.util.List;

public interface BookService {

    public List<Books> findAll();

    public Books findById(int theId);

    public void save(Books thebook);

    public void deleteById(int theId);
}
