package com.example.Online_Bus_Reservation_Project.repository;
import com.example.Online_Bus_Reservation_Project.entity.Role;
   import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepo extends JpaRepository<Role,Long> {
        Role findByName(String name);
   }

