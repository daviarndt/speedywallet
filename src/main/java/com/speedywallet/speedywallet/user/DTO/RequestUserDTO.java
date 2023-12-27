package com.speedywallet.speedywallet.user.DTO;

import com.speedywallet.speedywallet.user.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RequestUserDTO(

        @NotBlank @Size(min = 3)
        String firstName,

        @NotBlank @Size(min = 3)
        String lastName,

        @NotBlank @Size(min = 11, max = 14)
        String document,

        @NotBlank @Email
        String email,

        @NotBlank @Size(min = 8)
        String password,

        @NotNull
        UserType userType
) {
}
