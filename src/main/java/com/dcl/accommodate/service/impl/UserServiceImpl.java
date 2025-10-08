package com.dcl.accommodate.service.impl;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.enums.UserRole;
import com.dcl.accommodate.exception.handler.UserAlreadyExistsByEmailException;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.repository.UserRepository;
import com.dcl.accommodate.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public void registerUser(UserRegistrationRequest request) {
        if(userRepository.existsByEmail(request.email()))
            throw new UserAlreadyExistsByEmailException("user account already exists by given email");

        var user = this.toUser(request);
        user.setUserRole(UserRole.GUEST);
        userRepository.save(user);

    }
    private User toUser(UserRegistrationRequest request) {
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .dateOfBirth(request.dateOfBirth())
                .build();
        return user;
    }


}
