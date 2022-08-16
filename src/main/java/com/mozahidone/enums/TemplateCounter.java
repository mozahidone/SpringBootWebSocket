package com.mozahidone.enums;

public enum TemplateCounter {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4);
    private final int value;
    private TemplateCounter(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}