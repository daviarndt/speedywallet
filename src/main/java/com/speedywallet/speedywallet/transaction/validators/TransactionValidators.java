package com.speedywallet.speedywallet.transaction.validators;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;

public interface TransactionValidators {

    void validate(RequestTransactionDTO requestTransactionDTO);
}
