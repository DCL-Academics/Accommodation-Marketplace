package com.dcl.accommodate.exception;

public class UserAlreadyExistsByEmailException extends RuntimeException {
    public UserAlreadyExistsByEmailException(String message) {
        super(message);
    }
}
