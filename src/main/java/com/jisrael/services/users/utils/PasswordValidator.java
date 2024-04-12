package com.jisrael.services.users.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isValidPassword(String password, String regex) {
        regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[$&@*%])[A-Za-z\\d$&@*%]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
