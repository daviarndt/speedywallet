package com.speedywallet.speedywallet.transaction;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.user.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", updatable = false, nullable = false)
    private Long transactionId;

    @Column(name = "amount", nullable = false)
    @NotNull(message = "Amount is mandatory")
    private BigDecimal amount;

    @JoinColumn(name = "payer_id", nullable = false)
    @ManyToOne
    private UserModel payer;

    @JoinColumn(name = "payee_id", nullable = false)
    @ManyToOne
    private UserModel payee;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt = LocalDateTime.now();

    public TransactionModel(BigDecimal amount, UserModel payer, UserModel payee) {
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;
    }

    public TransactionModel() {
    }

    public TransactionModel(RequestTransactionDTO requestTransactionDTO, UserModel payer, UserModel payee) {
        this.amount = requestTransactionDTO.amount();
        this.payer = payer;
        this.payee = payee;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UserModel getPayer() {
        return payer;
    }

    public void setPayer(UserModel payer) {
        this.payer = payer;
    }

    public UserModel getPayee() {
        return payee;
    }

    public void setPayee(UserModel payee) {
        this.payee = payee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
