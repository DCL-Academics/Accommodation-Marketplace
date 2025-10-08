package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.wrapper.ApiAck;
import com.dcl.accommodate.security.jwt.JwtService;
import com.dcl.accommodate.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.Duration;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService; // inject JwtService

    @PostMapping("/register")
    public ResponseEntity<ApiAck> registerUser(@RequestBody UserRegistrationRequest request) {
        userService.registerUser(request);
        return ResponseEntity
                .created(URI.create("/api/v1/profile"))
                .body(new ApiAck(true, "User registered successfully"));
    }

    // --- NEW endpoint to test JWT token ---
    @GetMapping("/test-token")
    public ResponseEntity<Claims> testToken(@RequestParam String token) {
        try {
            Claims claims = jwtService.extractClaims(token);
            return ResponseEntity.ok(claims);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(null); // invalid token
        }
    }
}
