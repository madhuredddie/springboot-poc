package com.example.librarymanagement.Dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.example.librarymanagement.Entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class BooksDaoimplementaion implements BooksDao{

    private EntityManager entityManager;
    @Autowired
    public BooksDaoimplementaion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Books> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Books> theQuery =
                currentSession.createQuery("from Books", Books.class);

        // execute query and get result list
        List<Books> books = theQuery.getResultList();

        // return the results
        return books;
    }

    @Override
    public Books findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Books thebook= currentSession.get(Books.class,theId);
        return thebook;
    }

    @Override
    public void save(Books thebook) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(thebook);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from books where id=:bookId");
        theQuery.setParameter("bookId", theId);

        theQuery.executeUpdate();

    }
}
