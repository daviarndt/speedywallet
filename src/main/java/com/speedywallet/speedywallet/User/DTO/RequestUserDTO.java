package com.speedywallet.speedywallet.User.DTO;

import com.speedywallet.speedywallet.User.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RequestUserDTO(

        @NotBlank
        String fullName,

        @NotBlank
        String document,

        @NotBlank @Email
        String email,

        @NotBlank @Size(min = 8)
        String password,

        @NotNull
        UserType userType
) {
}
