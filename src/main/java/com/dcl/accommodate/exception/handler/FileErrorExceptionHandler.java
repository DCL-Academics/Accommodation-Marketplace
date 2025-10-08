package com.dcl.accommodate.exception.handler;

import com.dcl.accommodate.dto.wrapper.ApiErrors;
import com.dcl.accommodate.dto.wrapper.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

public class FileErrorExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object>  handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        List<FieldError> errors = this.getFieldErrors(ex.getAllErrors());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrors(
                        false,
                        "invalid input",
                        errors
                ));
    }

    private List<FieldError> getFieldErrors(List<ObjectError> errors) {
        return errors.stream()
                .map(error ->(org.springframework.validation.FieldError)error)
                .map(fieldError -> new FieldError(
                        fieldError.getField(),
                        fieldError.getRejectedValue(),
                        fieldError.getDefaultMessage()
                )).toList();
    }

}
