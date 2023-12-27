package com.speedywallet.speedywallet.User.DTO;

import com.speedywallet.speedywallet.User.UserModel;
import com.speedywallet.speedywallet.User.UserType;

public record ResponseUserDTO(
        Long id,
        String firstName,
        String lastName,
        String document,
        String email,
        UserType userType
) {
    public ResponseUserDTO(UserModel userModel) {
        this(
                userModel.getId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getDocument(),
                userModel.getEmail(),
                userModel.getUserType()
        );
    }
}
