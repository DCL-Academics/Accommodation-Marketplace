package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.wrapper.ApiAcknowledge;
import com.dcl.accommodate.service.contracts.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiAcknowledge>  registerUser(@RequestBody @Valid UserRegistrationRequest request){
        userService.registerUser(request);
        return ResponseEntity.created(URI.create(("/api/v1/profile")))
                .body(new ApiAcknowledge(true,"User registered successfully"));
    }
}
