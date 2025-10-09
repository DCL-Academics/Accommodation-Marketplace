package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.wrapper.ApiAck;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public ResponseEntity<ApiAck> health(){
        return ResponseEntity.ok(
        new ApiAck(
                true,
                "Accommodation Marketplace is UP and Running."
        ));
    }
}
