package com.example.librarymanagement.controller;

import com.example.librarymanagement.Entity.Books;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class Homepage {

    private BookService theBookservice;

    @Autowired
    public Homepage(BookService theBookservice) {
        this.theBookservice = theBookservice;
    }

    @GetMapping("/books")
    public List<Books> findall()
    {
        return theBookservice.findAll();
    }
    @GetMapping("/books/{bookId}")
    public Books getBook(@PathVariable int bookId) {

        Books theBook = theBookservice.findById(bookId);

        if (theBook == null) {
            throw new RuntimeException("Book id  is not found - " +bookId );
        }

        return theBook;

    }

    @PostMapping("/books")
    public Books addEmployee(@RequestBody Books theBook) {

        theBook.setId(0);

        theBookservice.save(theBook);

        return theBook;
    }

    @PutMapping("/books")
    public Books updateEmployee(@RequestBody Books theBook) {

        theBookservice.save(theBook);

        return theBook;
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteEmployee(@PathVariable int bookId) {

        Books tempBook = theBookservice.findById(bookId);

        // throw exception if null

        if (tempBook== null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }

        theBookservice.deleteById(bookId);

        return "Deleted book id - " + bookId;
    }
}
