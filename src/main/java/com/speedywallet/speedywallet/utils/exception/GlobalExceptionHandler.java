package com.speedywallet.speedywallet.utils.exception;

import com.speedywallet.speedywallet.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserFoundByEmailOrDocumentException.class)
    public ResponseEntity<ApiResponse> handleUserFoundByEmailOrDocumentException(UserFoundByEmailOrDocumentException ex) {
        return new ResponseEntity<>(ApiResponse.exception(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ApiResponse.exception(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();
        return new ResponseEntity<>(errors.stream().map(ErrorsDataValidation::new).toList(), HttpStatus.BAD_REQUEST);
    }

    public record ErrorsDataValidation(String field, String message) {
        public ErrorsDataValidation(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
