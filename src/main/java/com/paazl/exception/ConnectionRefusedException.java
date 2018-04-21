package com.paazl.exception;

public class ConnectionRefusedException extends RuntimeException {
    public ConnectionRefusedException(String s) {
        super(s);
    }
}
