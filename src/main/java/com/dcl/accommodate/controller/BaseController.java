package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.wrapper.ApiAck;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BaseController {
    @GetMapping("/health")
    public ResponseEntity<ApiAck> health(){
        return ResponseEntity.ok(
                new ApiAck(
                        true , "accommodation MarketPlace is UP and RUNNING."
                )
        );
    }
}
