package com.ashwin.ukforum.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
    @Size(min=6, max=12, message = "The username should be between 6 and 12 characters")
    private String username;

    @NotNull
    @Size(min=6, max=25, message = "The password should be between 6 and 25 characters")
    private String password;

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
}
