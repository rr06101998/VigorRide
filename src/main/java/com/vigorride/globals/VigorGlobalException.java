package com.vigorride.globals;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VigorGlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String detail;

    public VigorGlobalException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
    public VigorGlobalException(String message){
        super(message);
    }

    public VigorGlobalException(String message,String errorCode,String detail){
        super(message);
        this.errorCode=errorCode;
        this.detail=detail;
    }

}
