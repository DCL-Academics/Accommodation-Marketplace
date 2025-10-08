package com.dcl.accommodate.service;

import com.dcl.accommodate.dto.response.RegisterResponse;
import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.exception.handler.UserAlreadyExistsByEmailException;

public interface UserService {
    RegisterResponse register(UserRegistrationRequest request) throws UserAlreadyExistsByEmailException;

    void registerUser(UserRegistrationRequest request);
}
