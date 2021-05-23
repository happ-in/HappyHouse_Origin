package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.domain.UserImage;

public interface UserService {
    User findByIdAndPassword(User user);

    boolean join(User user);

    boolean findById(String userid);
}
