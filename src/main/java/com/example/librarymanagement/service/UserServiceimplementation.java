package com.example.librarymanagement.service;

import com.example.librarymanagement.Entity.Users;
import com.example.librarymanagement.jparepo.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimplementation implements UserService{


    private UserJpaRepository theUserJpaReopsitory;

    @Autowired
    public UserServiceimplementation(UserJpaRepository theUserJpaReopsitory) {
        this.theUserJpaReopsitory = theUserJpaReopsitory;
    }

    public List<Users> findAll() {
        return theUserJpaReopsitory.findAll();
    }

    @Override
    public Optional<Users> findById(int theId) {

       /* Optional<Users> result = theUserJpaReopsitory.findById(theId);
        Users theuser= null;
        if(result.isPresent())
        {
            theuser=result.get();
        }
        else
        {
            throw new RuntimeException(" user not found");
        }*/
        return theUserJpaReopsitory.findById(theId) ;
    }

    @Override
    public void save(Users theuser) {
        theUserJpaReopsitory.save(theuser);

    }

    @Override
    public void deleteById(int theId) {

        theUserJpaReopsitory.deleteById(theId);

    }
}
