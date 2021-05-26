package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.Email;
import com.ssafy.happyhouse.model.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> selectAll();

    User findByIdAndPassword(User user);

    User findById(String userid);

    User findByIdAndEmail(Email email);

    boolean join(User user);

    boolean findByIdList(String userid);

    boolean update(User user);

    boolean delete(String userid);

    boolean updatePassword(Map map);
}
