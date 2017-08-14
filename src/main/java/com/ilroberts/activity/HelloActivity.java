package com.ilroberts.activity;


public class HelloActivity implements Activity {

    private final String message;

    public HelloActivity(String message) {
        this.message = message;
    }

    public String perform() {
        return message;
    }


}
