package com.example.Online_Bus_Reservation_Project.dto;

//import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//dto for registration form
public class RegisterDto {
//   @NotEmpty
    private  String name;
//    @NotEmpty
    private String username;
//    @NotEmpty
    private  String email;
//    @NotEmpty
    private  String password;

}