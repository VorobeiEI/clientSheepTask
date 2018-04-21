package com.paazl.utils;

import java.util.Date;

public class ExceptionUtils {

    public static String textOfException() {
        return "Connection refused... " + new Date().toString();
    }
}
