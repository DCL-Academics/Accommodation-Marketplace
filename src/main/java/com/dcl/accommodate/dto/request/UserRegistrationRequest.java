package com.dcl.accommodate.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotBlank(message = "first_name is required")
        @Size(min = 2, max = 50, message = "first_name length must be between 2 and 50")
        @Pattern(
                regexp = "^[A-Z][a-zA-Z\\s'-]{1,49}$",
                message = "first_name must start with a capital letter and can contain letters, spaces, hyphens, and apostrophes"
        )
        @NotNull(message = "first_name cannot be null")
        @JsonProperty("first_name")
        String firstName,

        @NotBlank(message = "last_name is required")
        @Size(min = 2, max = 50, message = "last_name length must be between 2 and 50")
        @Pattern(
                regexp = "^[A-Z][a-zA-Z\\s'-]{1,49}$",
                message = "last_name must start with a capital letter and can contain letters, spaces, hyphens, and apostrophes"
        )
        @NotNull(message = "last_name cannot be null")
        @JsonProperty("last_name")
        String lastName,

        @NotNull(message = "Date of birth is required")
        @Past(message = "Date of birth must be in the past")
        @NotNull(message = "date_of_birth cannot be null")
        @JsonProperty("date_of_birth")
        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
        LocalDate dateOfBirth,

        @Email(message = "Email must be valid")
        @NotBlank(message = "Email is required")
        @Pattern(
                regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
                message = "Email must match pattern"
        )
        @NotNull(message = "email cannot be null")
        @JsonProperty("email")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 20, message = "Password must be 8 to 20 characters long")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,20}$",
                message = "Password must include uppercase, lowercase, digit, and special character"
        )
        @NotNull(message = "password cannot be null")
        @JsonProperty("password")
        String password,

        @NotNull(message = "phone_number cannot be null")
        @NotBlank(message = "phone_number is required")
        @JsonProperty("phone_number")
        @Pattern(
                regexp = "^[6-9]\\d{9}$",
                message = "Phone number must be 10 digits and start with 6, 7, 8, or 9"
        )
        String phoneNumber) {

}
