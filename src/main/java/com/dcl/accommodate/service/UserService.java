package com.dcl.accommodate.service;


import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.model.User;

import java.util.List;

public interface UserService  {

    void registerUser(UserRegistrationRequest request);


}
