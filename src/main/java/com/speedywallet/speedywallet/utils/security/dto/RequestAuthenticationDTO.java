package com.speedywallet.speedywallet.utils.security.dto;

import jakarta.validation.constraints.NotNull;

public record RequestAuthenticationDTO(
        @NotNull
        String login,

        @NotNull
        String password
) {
}
