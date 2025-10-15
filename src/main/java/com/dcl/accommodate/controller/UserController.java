package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.request.UserLoginRequest;
import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.response.AuthResponse;
import com.dcl.accommodate.dto.wrapper.ApiAck;
import com.dcl.accommodate.dto.wrapper.ApiResponse;
import com.dcl.accommodate.service.contracts.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/public/register")
    public ResponseEntity<ApiAck> registerUser(@Validated @RequestBody UserRegistrationRequest user){
        userService.registerUser(user);
        return ResponseEntity.created(URI.create("api/v1/profile"))
                .body(new ApiAck(true,"user registered successfully"));
    }

    @PostMapping("/public/login")
    public ResponseEntity<ApiResponse<AuthResponse>> loginUser(@Valid @RequestBody UserLoginRequest userLoginRequest){
        var token = userService.loginUser(userLoginRequest);
        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "user successfully logged in",
                token
        ));
    }
    @PostMapping("/public/refresh")
    public ResponseEntity<ApiResponse<AuthResponse>> refreshLogin(@RequestHeader("Authorization") String bearerToken){
        if(bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>(false, "Invalid Authorization header", null));
        }

        // Authenticated user should already be set in SecurityContext
        AuthResponse authResponse = userService.refreshLogin();

        return ResponseEntity.ok(new ApiResponse<>(true, "Token refreshed successfully", authResponse));
    }
}