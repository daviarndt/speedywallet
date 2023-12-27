package com.speedywallet.speedywallet.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {

    @Query(
            value = "SELECT * FROM transactions WHERE payer_id=:payerId",
            nativeQuery = true
    )
    Page<TransactionModel> findAllTransactionsByUserId(@Param("payerId") Long payerId, Pageable pageable);
}
