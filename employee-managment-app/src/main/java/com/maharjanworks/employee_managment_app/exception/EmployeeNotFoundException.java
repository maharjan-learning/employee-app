package com.maharjanworks.employee_managment_app.exception;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends RuntimeException{

    private final HttpStatus httpStatus;

    public EmployeeNotFoundException(String message) {
        super(message);
        this.httpStatus=HttpStatus.NOT_FOUND;
    }

}
