package com.speedywallet.speedywallet.transaction.dto;

import java.math.BigDecimal;

public record RequestTransactionDTO(
        BigDecimal amount,
        Long payerId,
        Long payeeId
) {
}
