package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.Email;
import com.ssafy.happyhouse.model.domain.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    List<User> findByIdList(String userid);

    User findByIdAndPassword(User user);

    User findById(String userid);

    User findByIdAndEmail(Email email);

    int join(User user);

    int update(User user);

    int delete(String userid);

    List<User> selectAll();

    int updatePassword(Map map);
}
