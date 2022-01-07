package com.holtak.holidays4j.exception;

public class Holiday4jException extends Exception {

    public Holiday4jException(String message) {
        super(message);
    }

    public Holiday4jException(String message, Throwable cause) {
        super(message, cause);
    }
}
