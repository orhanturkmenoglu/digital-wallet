package com.digitalwallet.atm.service.utils;

import java.util.Arrays;

public class LogHelper {

    public static String getMethodAndClassInfo(Object...params){
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        String methodInfo = String.format("Method %s in class %s", element.getMethodName(), element.getClassName());

        if (params != null && params.length > 0) {
            methodInfo += " | Parameters: " + Arrays.toString(params);
        }

        return methodInfo;
    }
}
