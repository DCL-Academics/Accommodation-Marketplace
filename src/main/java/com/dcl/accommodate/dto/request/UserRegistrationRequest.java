package com.dcl.accommodate.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
public record UserRegistrationRequest(

        @NotNull(message = "first_name cannot be null")
        @NotBlank(message = "first_name cannot be blank")
        @Pattern(
                regexp = "^[A-Z][a-zA-Z\\s'-]{1,49}$",
                message = "first_name must start with a captital letter and can contain letters, spaces, hyphens, and apostrophes (2-50 characters)"
        )
        @JsonProperty("first_name")
        String firstName,

        @NotNull(message = "last_name cannot be null")
        @NotBlank(message = "last_name cannot be blank")
        @Pattern(
                regexp = "^[A-Z][a-zA-Z\\s'-]{0,49}$",
                message = "last_name must contain only alphabetic characters"
        )
        @JsonProperty("last_name")
        String lastName,

        @NotNull(message = "date_of_birth cannot be null")
        @JsonProperty("date_of_birth")
        LocalDate dateOfBirth,

        @NotNull(message = "email cannot be null")
        @NotBlank(message = "email cannot be blank")
        @Email(
                regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
                message = "email must be in valid format"
        )
        @JsonProperty("email")
        String email,

        @NotNull(message = "password cannot be null")
        @NotBlank(message = "password cannot be blank")
        @JsonProperty("password")
        String password,

        @NotNull(message = "phone_number cannot be null")
        @NotBlank(message = "phone_number cannot be blank")
        @Pattern(
                regexp = "^(?:\\+91\\s)?[6-9]\\d{9}$",
                message = "phone_number must be in valid format, starting with digits 6-9 and may include country code +91"
        )
        @JsonProperty("phone_number")
        String phoneNumber
) {}
