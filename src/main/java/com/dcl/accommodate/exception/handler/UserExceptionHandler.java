package com.dcl.accommodate.exception.handler;

import com.dcl.accommodate.dto.wrapper.ApiAcknowledge;
import com.dcl.accommodate.exception.UserAlreadyExistsByEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiAcknowledge> handelUserAlreadyExistByEmail(UserAlreadyExistsByEmailException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiAcknowledge(false, ex.getMessage()));
    }

}
