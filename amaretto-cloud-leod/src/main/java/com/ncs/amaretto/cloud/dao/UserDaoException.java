package com.ncs.amaretto.cloud.dao;

public class UserDaoException extends Exception {
    private static final long serialVersionUID = -3699012551851391050L;
    private String message;

    public UserDaoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
