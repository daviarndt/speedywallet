package com.speedywallet.speedywallet.transaction.validators;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.user.UserModel;
import com.speedywallet.speedywallet.user.UserService;
import com.speedywallet.speedywallet.utils.exception.UserIsShopkeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatePayerIsCommon implements TransactionValidators {

    @Autowired
    UserService userService;

    @Override
    public void validate(RequestTransactionDTO requestTransactionDTO) {
        UserModel payer = userService.getUserById(requestTransactionDTO.payerId());

        if (payer.getUserType().equals("SHOPKEEPER"))
            throw new UserIsShopkeeperException("User isn't allowed");
    }
}
