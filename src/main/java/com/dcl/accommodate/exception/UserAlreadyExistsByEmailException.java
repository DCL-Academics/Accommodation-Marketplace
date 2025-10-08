package com.dcl.accommodate.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String s) {
    }
}
