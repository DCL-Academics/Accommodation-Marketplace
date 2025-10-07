package com.dcl.accommodate.dto.wrapper;

public record FieldErrors(
        String rejectedField,
        Object rejectedValue,
        String message
) {
}
