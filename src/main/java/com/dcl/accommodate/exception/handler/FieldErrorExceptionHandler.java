package com.dcl.accommodate.exception.handler;

import com.dcl.accommodate.dto.wrapper.ApiErrors;
import com.dcl.accommodate.dto.wrapper.FieldErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<FieldErrors> errors = this.getFieldErrors(ex.getAllErrors());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrors(
                        false,
                        "Invalid Input",
                        errors
                ));
    }

    private List<FieldErrors> getFieldErrors(List<ObjectError> errors){
        return errors.stream()
                .map(error -> (org.springframework.validation.FieldError) error)
                .map(fieldError -> new FieldErrors(
                        fieldError.getField(),
                        fieldError.getRejectedValue(),
                        fieldError.getDefaultMessage()
                )).toList();
    }

}
