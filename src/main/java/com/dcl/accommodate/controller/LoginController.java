package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.request.LoginRequest;
import com.dcl.accommodate.dto.response.LoginResponse;
import com.dcl.accommodate.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/<version>/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)
    {
        return LoginResponse loginResponse =loginService.validateUser(loginRequest);
    }
}
