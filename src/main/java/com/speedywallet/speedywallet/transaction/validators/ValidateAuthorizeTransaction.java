package com.speedywallet.speedywallet.transaction.validators;

import com.speedywallet.speedywallet.transaction.dto.RequestTransactionDTO;
import com.speedywallet.speedywallet.utils.exception.UnauthorizedTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ValidateAuthorizeTransaction implements TransactionValidators {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url.transaction.authorization}")
    private String authorizationUrl;

    @Override
    public void validate(RequestTransactionDTO requestTransactionDTO) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity(authorizationUrl, Map.class);

        if (!(authorizationResponse.getStatusCode() == HttpStatus.OK)) {
            throw new UnauthorizedTransactionException("The transfer was not authorized");
        }

        String message = (String) authorizationResponse.getBody().get("message");
        "Autorizado".equalsIgnoreCase(message);
    }
}
