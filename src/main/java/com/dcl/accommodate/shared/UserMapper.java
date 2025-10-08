package com.dcl.accommodate.shared;

import com.dcl.accommodate.dto.response.RegisterResponse;
import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.model.User;

public class UserMapper {

    public static User toEntity(UserRegistrationRequest request) {
        User user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setDateOfBirth(request.dateOfBirth());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setPhoneNumber(request.phoneNumber());
        return user;
    }

    public static RegisterResponse toResponse(User user) {
        return new RegisterResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getUserRole(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAvatar(),
                user.getCreatedDate()
        );
    }
}
