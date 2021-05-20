package com.ssafy.happyhouse.model.service.Impl;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.repository.UserRepository;
import com.ssafy.happyhouse.model.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public User findByIdAndPassword(User user) {
        return sqlSession.getMapper(UserRepository.class).findByIdAndPassword(user);
    }

    @Override
    public boolean join(User user) {
        return false;
    }
}
