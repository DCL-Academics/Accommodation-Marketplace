package com.dcl.accommodate.exception.handler;

public class UserAlreadyExistsByEmailException extends RuntimeException {
    public UserAlreadyExistsByEmailException(String message) {
        super(message);
    }
}
