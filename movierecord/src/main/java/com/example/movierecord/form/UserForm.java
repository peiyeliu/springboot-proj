package com.example.movierecord.form;

import javax.validation.constraints.*;

/**
 * The UserForm object saves the registration input from user.
 * Validation will be checked here.
 */

public class UserForm {

    @Size(min = 1, message = "username should not be blank")
    private String username;

    @Size(min = 6, message = "The password should contains at lease 6 digits")
    private String password;

    @NotNull(message = "Please input your phone number")
    private Long phone;

    @NotNull(message = "Email address are required")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Please input valid email address")
    private String email;

    @NotNull(message = "Please confirm your password")
    private String confirmPassword;

    public UserForm() {
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean confirmPassword(){
        return this.confirmPassword.equals(this.password);
    }
}
