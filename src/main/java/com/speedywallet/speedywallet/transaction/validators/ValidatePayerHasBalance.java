package com.speedywallet.speedywallet.transaction.validators;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.user.UserModel;
import com.speedywallet.speedywallet.user.UserService;
import com.speedywallet.speedywallet.utils.exception.InsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatePayerHasBalance implements TransactionValidators {

    @Autowired
    UserService userService;

    @Override
    public void validate(RequestTransactionDTO requestTransactionDTO) {
        UserModel payer = userService.getUserById(requestTransactionDTO.payerId());

        if (payer.getBalance().compareTo(requestTransactionDTO.amount()) < 0)
            throw new InsufficientBalanceException("User has insufficient balance to complete the transfer");
    }
}
