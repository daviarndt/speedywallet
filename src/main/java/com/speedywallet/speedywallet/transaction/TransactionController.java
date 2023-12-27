package com.speedywallet.speedywallet.transaction;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.transaction.dto.ResponseTransactionDTO;
import com.speedywallet.speedywallet.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<ApiResponse<ResponseTransactionDTO>> saveTransaction(@RequestBody @Valid RequestTransactionDTO requestTransactionDTO) {
        ResponseTransactionDTO responseTransactionDTO = transactionService.saveTransaction(requestTransactionDTO);
        return new ResponseEntity<>(ApiResponse.success(responseTransactionDTO), HttpStatus.CREATED);
    }
}
