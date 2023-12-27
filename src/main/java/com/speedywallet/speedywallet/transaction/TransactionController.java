package com.speedywallet.speedywallet.transaction;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.transaction.dto.ResponseTransactionDTO;
import com.speedywallet.speedywallet.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ResponseTransactionDTO>>> getTransactionsByUser(@PageableDefault(size = 25) Pageable pageable, Principal principal) {
        Page<ResponseTransactionDTO> responseTransactionDTOPage = transactionService.getTransactionsByUser(pageable, principal.getName());
        return new ResponseEntity<>(ApiResponse.success(responseTransactionDTOPage), HttpStatus.OK);
    }
}
