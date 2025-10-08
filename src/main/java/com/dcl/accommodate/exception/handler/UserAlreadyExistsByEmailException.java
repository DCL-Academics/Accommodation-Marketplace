package com.dcl.accommodate.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserAlreadyExistsByEmailException extends RuntimeException {
    public UserAlreadyExistsByEmailException(String message) {
        super(message);
    }
}
