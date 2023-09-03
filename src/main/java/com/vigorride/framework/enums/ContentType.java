package com.vigorride.framework.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ContentType {
    PDF("PDF", ".pdf");


    private String code;
    private String extension;

    private ContentType(final String code, final String extension) {
        this.code = code;
        this.extension = extension;
    }
    

    public String getExtension() {
        return extension;
    }
}
