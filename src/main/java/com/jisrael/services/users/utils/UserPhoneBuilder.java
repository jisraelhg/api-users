package com.jisrael.services.users.utils;

import com.jisrael.services.users.entity.User;
import com.jisrael.services.users.entity.UserPhone;
import com.jisrael.services.users.model.NewUserPhone;

public class UserPhoneBuilder {

    public static UserPhone build(NewUserPhone newUserPhone, User user) {
        UserPhone userPhone = new UserPhone();
        userPhone.setUser(user);
        userPhone.setNumber(newUserPhone.getNumber());
        userPhone.setCityCode(newUserPhone.getCitycode());
        userPhone.setCountryCode(newUserPhone.getCountrycode());
        return userPhone;
    }
}
