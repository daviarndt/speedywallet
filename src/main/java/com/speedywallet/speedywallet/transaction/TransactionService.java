package com.speedywallet.speedywallet.transaction;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.transaction.dto.ResponseTransactionDTO;
import com.speedywallet.speedywallet.transaction.validators.TransactionValidators;
import com.speedywallet.speedywallet.user.UserModel;
import com.speedywallet.speedywallet.user.UserService;
import com.speedywallet.speedywallet.utils.exception.UserIsNotOwnUserException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private List<TransactionValidators> transactionValidators;

    @Transactional
    public ResponseTransactionDTO saveTransaction(RequestTransactionDTO requestTransactionDTO, String userEmail) {
        transactionValidators.forEach(v -> v.validate(requestTransactionDTO));

        UserModel payer = userService.getUserById(requestTransactionDTO.payerId());
        UserModel payee = userService.getUserById(requestTransactionDTO.payeeId());

        if (!payer.getEmail().equals(userEmail)) {
            throw new UserIsNotOwnUserException("User tried to make transfer for another user");
        }

        payer.setBalance(payer.getBalance().subtract(requestTransactionDTO.amount()));
        payee.setBalance(payee.getBalance().add(requestTransactionDTO.amount()));

        TransactionModel transactionModel = transactionRepository.save(
                new TransactionModel(requestTransactionDTO, payer, payee));

        userService.saveUser(payer);
        userService.saveUser(payee);

        return new ResponseTransactionDTO(transactionModel);
    }

    public Page<ResponseTransactionDTO> getTransactionsByUser(Pageable pageable, String email) {
        UserModel user = userService.getUserByEmail(email);
        return transactionRepository.findAllTransactionsByUserId(user.getUserId(), pageable).map(ResponseTransactionDTO::new);
    }
}
