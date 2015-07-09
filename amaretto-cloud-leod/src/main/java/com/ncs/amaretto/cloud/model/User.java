package com.ncs.amaretto.cloud.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "userId", "username", "password", "emailAddress" })
public class User {

    @JsonProperty("UserId")
    private int userId;

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("EmailAddress")
    private String emailAddress;

    public static final User newInstance(int userId, String username, String password, String emailAddress) {
        User user = new User();

        user.userId = userId;
        user.username = username;
        user.password = password;
        user.emailAddress = emailAddress;

        return user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
