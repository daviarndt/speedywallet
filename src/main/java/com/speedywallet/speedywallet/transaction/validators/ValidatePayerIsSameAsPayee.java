package com.speedywallet.speedywallet.transaction.validators;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.utils.exception.PayerIsPayeeException;
import org.springframework.stereotype.Component;

@Component
public class ValidatePayerIsSameAsPayee implements TransactionValidators {


    @Override
    public void validate(RequestTransactionDTO requestTransactionDTO) {
        if (requestTransactionDTO.payerId() == requestTransactionDTO.payeeId())
            throw new PayerIsPayeeException("Not possible to transfer if payer is the same as payee");
    }
}
