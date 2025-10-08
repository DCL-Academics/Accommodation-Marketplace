package com.dcl.accommodate.dto.response;

import com.dcl.accommodate.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private UUID userId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private UserRole userRole;
    private String email;
    private String phoneNumber;
    private String avatar;
    private Instant createdDate;
}
