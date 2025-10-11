package com.dcl.accommodate.service.contracts;


import com.dcl.accommodate.dto.request.UserLoginRequest;
import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.response.AuthResponse;

import java.util.Map;

public interface UserService {

    public void registerUser(UserRegistrationRequest registration);

    AuthResponse loginUser(UserLoginRequest request);
}
