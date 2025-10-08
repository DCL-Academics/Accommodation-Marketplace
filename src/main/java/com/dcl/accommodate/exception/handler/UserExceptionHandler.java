package com.dcl.accommodate.exception.handler;

import com.dcl.accommodate.dto.wrapper.ApiAck;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsByEmailException.class)
    public ResponseEntity<ApiAck> handleUserAlreadyExistsByEmailException(UserAlreadyExistsByEmailException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiAck(false, ex.getMessage()));
    }
}

