package com.speedywallet.speedywallet.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
}
