package com.jisrael.services.users.services;

import com.jisrael.services.users.entity.User;
import com.jisrael.services.users.model.NewUserRequest;

import java.util.List;

public interface UserService {
    User getUserId(String userId);

    User createUser(NewUserRequest user);

    List<User> findAll();
}
