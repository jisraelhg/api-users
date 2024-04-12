package com.jisrael.services.users;

import com.jisrael.services.users.entity.User;
import com.jisrael.services.users.model.NewUserRequest;

import java.util.Date;

public class UserBuilder {

    public static User build(NewUserRequest newUserRequest, String userId, String token, String password) {
        User user = new User();
        user.setActive(true);
        user.setCreatedAt(new Date());
        user.setName(newUserRequest.getName());
        user.setEmail(newUserRequest.getEmail());
        user.setId(userId);
        user.setToken(token);
        user.setModifiedAt(new Date());
        user.setPassword(password);
        return user;
    }
}
