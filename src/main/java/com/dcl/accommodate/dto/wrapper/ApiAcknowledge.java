package com.dcl.accommodate.dto.request;

public record ApiAck(
        boolean success,
        String message
) {
}