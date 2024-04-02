package com.example.Online_Bus_Reservation_Project.repository;

import com.example.Online_Bus_Reservation_Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username,String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User findByEmail(String email);
   Optional<User> findById(Long id);


}
