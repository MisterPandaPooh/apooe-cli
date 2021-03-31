package com.lauriecs.utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public  class Validators {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (URISyntaxException | MalformedURLException exception) {
            return false;
        }
    }

}
