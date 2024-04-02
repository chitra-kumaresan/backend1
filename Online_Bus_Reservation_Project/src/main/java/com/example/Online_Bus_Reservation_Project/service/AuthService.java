package com.example.Online_Bus_Reservation_Project.service;


import com.example.Online_Bus_Reservation_Project.dto.JwtAuthResponse;
import com.example.Online_Bus_Reservation_Project.dto.LoginDto;
import com.example.Online_Bus_Reservation_Project.dto.RegisterDto;
import com.example.Online_Bus_Reservation_Project.entity.User;

import java.util.List;

public interface AuthService {
    String register(RegisterDto registerDto);


    JwtAuthResponse login(LoginDto loginDto);

    User getUser(String name);
    boolean oldPasswordIsValid(User user,String oldPassword);
    void changePassword(User user,String newPassword);
    void deleteById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User getById(Long id);



}