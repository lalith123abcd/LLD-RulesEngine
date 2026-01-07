package com.lld.ruleEnginne.rules;

public class Violation {
    private String message;

    public Violation(String message) {
        this.message=message;
    }

    public static Violation of(String message){
        return  new Violation(message);
    }
}
