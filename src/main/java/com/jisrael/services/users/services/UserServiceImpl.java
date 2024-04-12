package com.jisrael.services.users.services;

import com.jisrael.services.users.UserBuilder;
import com.jisrael.services.users.entity.User;
import com.jisrael.services.users.configuration.UsersException;
import com.jisrael.services.users.entity.UserPhone;
import com.jisrael.services.users.model.NewUserPhone;
import com.jisrael.services.users.model.NewUserRequest;
import com.jisrael.services.users.repositories.UserPhoneRepository;
import com.jisrael.services.users.repositories.UserRepository;
import com.jisrael.services.users.utils.JwtGenerator;
import com.jisrael.services.users.utils.PasswordValidator;
import com.jisrael.services.users.utils.UserPhoneBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserPhoneRepository userPhoneRepository;
    private final JwtGenerator jwtGenerator;
    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${users.validations.passwordRegex}")
    private String passRegex;

    public UserServiceImpl(UserRepository userRepository, UserPhoneRepository userPhoneRepository,
                           JwtGenerator jwtGenerator, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userPhoneRepository = userPhoneRepository;
        this.jwtGenerator = jwtGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserId(String userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new UsersException("user not found " + userId, HttpStatus.NOT_FOUND.value())
        );
    }

    @Override
    @Transactional
    public User createUser(NewUserRequest userRequest) {

        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new UsersException("El correo ya se encuentra registrado",
                    HttpStatus.BAD_REQUEST.value());
        }

        if (!PasswordValidator.isValidPassword(userRequest.getPassword(), passRegex)) {
            throw new UsersException("El password no cumple con las politicas de seguridad",
                    HttpStatus.BAD_REQUEST.value());
        }

        String userId = UUID.randomUUID().toString();
        String jwt = jwtGenerator.newToken(userId);
        String password = passwordEncoder.encode(userRequest.getPassword());

        User user = UserBuilder.build(userRequest, userId, jwt, password);
        userRepository.save(user);

        if (userRequest.getPhones() != null) {
            userRequest.getPhones().stream().forEach(userPhone -> createUserPhone(userPhone, user));
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public UserPhone createUserPhone(NewUserPhone newUserPhone, User user) {
        UserPhone userPhone = UserPhoneBuilder.build(newUserPhone, user);
        userPhoneRepository.save(userPhone);
        return userPhone;
    }
}
