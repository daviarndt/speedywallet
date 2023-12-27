package com.speedywallet.speedywallet.user.DTO;

import com.speedywallet.speedywallet.user.UserModel;
import com.speedywallet.speedywallet.user.UserType;

import java.math.BigDecimal;

public record ResponseUserDTO(
        Long userId,
        String firstName,
        String lastName,
        String document,
        String email,
        UserType userType,
        BigDecimal balance,
        boolean isActive
) {
    public ResponseUserDTO(UserModel userModel) {
        this(
                userModel.getUserId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getDocument(),
                userModel.getEmail(),
                userModel.getUserType(),
                userModel.getBalance(),
                userModel.isActive()
        );
    }
}
