package com.vigorride.globals;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class VigorBadRequestException extends VigorGlobalException {

    private static final long serialVersionUID = 1L;

    public VigorBadRequestException(String message) {
        super(message);
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().setAttribute("ResponseError",404);

    }
}
