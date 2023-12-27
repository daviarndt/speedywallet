package com.speedywallet.speedywallet.transaction;

import com.speedywallet.speedywallet.user.UserModel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", updatable = false, nullable = false)
    private Long transactionId;

    @Column(name = "amount")
    private BigDecimal amount;

    @JoinColumn(name = "payer_id", nullable = false)
    @ManyToOne
    private UserModel payer;

    @JoinColumn(name = "payee_id", nullable = false)
    @ManyToOne
    private UserModel payee;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt = LocalDateTime.now();
}
