package com.speedywallet.speedywallet.transaction.dto;

import com.speedywallet.speedywallet.transaction.TransactionModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ResponseTransactionDTO(
        Long transactionId,
        BigDecimal amount,
        Long payerId,
        Long payeeId,
        LocalDateTime createdAt
) {
    public ResponseTransactionDTO(TransactionModel transactionModel) {
        this(
                transactionModel.getTransactionId(),
                transactionModel.getAmount(),
                transactionModel.getPayer().getUserId(),
                transactionModel.getPayee().getUserId(),
                transactionModel.getCreatedAt()
        );
    }
}
