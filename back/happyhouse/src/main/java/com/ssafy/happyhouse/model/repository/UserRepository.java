package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.User;

import java.util.List;

public interface UserRepository {
    User findByIdAndPassword(User user);

    int join(User user);

    List<User> findByIdList(String userid);

    User findById(String userid);

    int update(User user);

    int delete(String userid);
}
