package com.dcl.accommodate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAlreadyExistsByEmailException extends RuntimeException {
    private final String message;
}
