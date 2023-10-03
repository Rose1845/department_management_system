package com.rose.crud.user.service;

import com.rose.crud.user.entity.User;
import com.rose.crud.user.request.RegistrationRequest;

public interface UserService {

    User register(RegistrationRequest user);
}
