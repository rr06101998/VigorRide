package com.vigorride.globals;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
    private String details;
}
