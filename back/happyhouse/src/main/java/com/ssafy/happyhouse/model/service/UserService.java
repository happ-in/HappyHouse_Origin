package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.User;

public interface UserService {
    User findByIdAndPassword(User user);

    boolean join(User user);

    boolean findByIdList(String userid);

    User findById(String userid);

    boolean update(User user);

    boolean delete(String userid);
}
