package com.jesthercostinar.joblisting.service;

import com.jesthercostinar.joblisting.dto.UserDto;
import com.jesthercostinar.joblisting.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
