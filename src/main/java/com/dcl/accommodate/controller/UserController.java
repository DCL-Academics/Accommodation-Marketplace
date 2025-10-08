package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.wrapper.ApiAck;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiAck> registerUser(@RequestBody UserRegistrationRequest request){
        userService.registerUser(request);
        return ResponseEntity.created(URI.create("/api/v1/profile"))
                .body(new ApiAck(true,"user registered successfully"));
    }


}
