package com.example.movierecord.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select distinct u from User u where u.username = ?1")
    User findUserByUsername(String username);
}
