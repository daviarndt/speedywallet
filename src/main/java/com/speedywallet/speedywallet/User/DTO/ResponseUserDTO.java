package com.speedywallet.speedywallet.User.DTO;

import com.speedywallet.speedywallet.User.UserModel;
import com.speedywallet.speedywallet.User.UserType;

public record ResponseUserDTO(
        Long id,
        String fullName,
        String document,
        String email,
        UserType userType
) {
    public ResponseUserDTO(UserModel userModel) {
        this(
                userModel.getId(),
                userModel.getFullName(),
                userModel.getDocument(),
                userModel.getEmail(),
                userModel.getUserType()
        );
    }
}
