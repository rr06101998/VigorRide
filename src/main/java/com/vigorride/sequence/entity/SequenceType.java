package com.vigorride.sequence.entity;

public enum SequenceType {
    INVOICE("INVOICE");

    private final String type;

    SequenceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
