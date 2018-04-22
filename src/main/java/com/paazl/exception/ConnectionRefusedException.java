package com.paazl.exception;

//consumer exception
public class ConnectionRefusedException extends RuntimeException {
    public ConnectionRefusedException(String s) {
        super(s);
    }
}
