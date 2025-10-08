package com.dcl.accommodate.service;

import com.dcl.accommodate.dto.request.LoginRequest;
import com.dcl.accommodate.dto.response.LoginResponse;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;


    public LoginResponse validateUser(LoginRequest loginRequest) {
//       Optional<User> optionalUser= userRepository.findByEmail(loginRequest.getEmail());
        return new LoginResponse();
    }
}
