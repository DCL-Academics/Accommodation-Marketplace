package com.dcl.accommodate.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String role;


}
