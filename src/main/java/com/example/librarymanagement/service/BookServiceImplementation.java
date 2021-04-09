package com.example.librarymanagement.service;

import com.example.librarymanagement.Dao.BooksDao;
import com.example.librarymanagement.Entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImplementation implements BookService{

    private BooksDao theBooksDao;
     @Autowired
    public BookServiceImplementation(BooksDao theBooksDao) {
        this.theBooksDao = theBooksDao;
    }

    @Override
    @Transactional
    public List<Books> findAll() {
        return theBooksDao.findAll();
    }

    @Override
    public Books findById(int theId) {
        return theBooksDao.findById(theId);
    }

    @Override
    public void save(Books thebook) {
             theBooksDao.save(thebook);
    }

    @Override
    public void deleteById(int theId) {
           theBooksDao.deleteById(theId);
    }
}
