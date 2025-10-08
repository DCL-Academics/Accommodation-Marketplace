package com.dcl.accommodate.service.impl;

import com.dcl.accommodate.dto.response.RegisterResponse;
import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.enums.UserRole;
import com.dcl.accommodate.exception.UserAlreadyExistsByEmailException;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.repository.UserRepository;
import com.dcl.accommodate.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public RegisterResponse register(UserRegistrationRequest request) throws UserAlreadyExistsByEmailException {
        if (userRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsByEmailException("User account already exists with the given email");
        }

        // Map DTO to entity
        User user = toUser(request);
        user.setUserRole(UserRole.GUEST);

        // Save user
        User savedUser = userRepository.save(user);

        // Return response
        return new RegisterResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getDateOfBirth(),
                savedUser.getUserRole(),
                savedUser.getEmail(),
                savedUser.getPhoneNumber(),
                savedUser.getAvatar(),
                savedUser.getCreatedDate()
        );
    }

    private User toUser(UserRegistrationRequest request) {
        return User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .dateOfBirth(request.dateOfBirth())
                .build();
    }
}
