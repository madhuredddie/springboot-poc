package com.example.librarymanagement.jparepo;

import com.example.librarymanagement.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users, Integer> {
}
