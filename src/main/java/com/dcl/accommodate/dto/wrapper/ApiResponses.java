package com.dcl.accommodate.dto.wrapper;

public record ApiResponses<T>(
        boolean success,
        String message,
        T data
) {}
