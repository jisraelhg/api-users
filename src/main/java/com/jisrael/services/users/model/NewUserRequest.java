package com.jisrael.services.users.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class NewUserRequest {
    @NotNull(message = "'name' no debe ser nulo")
    private String name;
    @Email
    @NotNull(message = "'email' no debe ser nulo")
    private String email;
    @NotNull(message = "'password' no debe ser nulo")
    private String password;
    private List<NewUserPhone> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<NewUserPhone> getPhones() {
        return phones;
    }

    public void setPhones(List<NewUserPhone> phones) {
        this.phones = phones;
    }
}
