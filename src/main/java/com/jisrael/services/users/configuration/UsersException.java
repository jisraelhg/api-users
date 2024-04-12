package com.jisrael.services.users.configuration;

public class UsersException extends RuntimeException {

    private int code;

    public UsersException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
