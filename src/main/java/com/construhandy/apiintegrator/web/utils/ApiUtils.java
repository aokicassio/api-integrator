package com.construhandy.apiintegrator.web.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiUtils {

    private ApiUtils() {
    }

    public static String getUpdateProductUri(String customId){
        return String.format("products/ref:%s", customId);
    }

    public static String generateBatchId(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return now.format(formatter);
    }

}
