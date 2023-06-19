package com.jesthercostinar.joblisting.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "First Name must not be empty")
    private String firstName;
    @NotEmpty(message = "Last Name must not be empty")
    private String lastName;
    @Email
    @NotEmpty(message = "Email must not be empty")
    private String email;
    @NotEmpty
    private String password;
}
