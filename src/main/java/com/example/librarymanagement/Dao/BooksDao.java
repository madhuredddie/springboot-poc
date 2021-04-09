package com.example.librarymanagement.Dao;

import com.example.librarymanagement.Entity.Books;

import java.util.List;

public interface BooksDao {
    public List<Books> findAll();

    public Books findById(int theId);

    public void save(Books thebook);

    public void deleteById(int theId);
}
