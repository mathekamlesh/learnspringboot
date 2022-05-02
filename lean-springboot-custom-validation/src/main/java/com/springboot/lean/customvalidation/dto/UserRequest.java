package com.springboot.lean.customvalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "username shouldn't be null")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "Invalid mobile no enter")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotEmpty
    private String nationality;
}
