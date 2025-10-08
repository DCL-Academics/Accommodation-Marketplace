package com.dcl.accommodate.handler;

import com.dcl.accommodate.dto.wrapper.ApiErrors;
import com.dcl.accommodate.dto.wrapper.FieldError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<FieldError> errors = getFieldErrors(ex.getBindingResult().getAllErrors());

        ApiErrors apiErrors = new ApiErrors(
                false,
                "Invalid input",
                errors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(apiErrors);
    }


    private List<FieldError> getFieldErrors(List<ObjectError> errors) {
        return errors.stream()
                .map(error -> (org.springframework.validation.FieldError) error)
                .map(fieldError -> new FieldError(
                        fieldError.getField(),
                        fieldError.getRejectedValue(),
                        fieldError.getDefaultMessage()
                ))
                .toList();
    }
}
