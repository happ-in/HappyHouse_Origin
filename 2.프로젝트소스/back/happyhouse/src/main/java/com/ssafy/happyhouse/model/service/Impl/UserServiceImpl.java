package com.ssafy.happyhouse.model.service.Impl;

import com.ssafy.happyhouse.model.domain.Email;
import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.repository.UserRepository;
import com.ssafy.happyhouse.model.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return sqlSession.getMapper(UserRepository.class).join(user) == 1;
    }

    @Override
    public boolean findByIdList(String userid) {
        return sqlSession.getMapper(UserRepository.class).findByIdList(userid).size() == 0;
    }
    @Override
    public User findById(String userid) {
        return sqlSession.getMapper(UserRepository.class).findById(userid);
    }

    @Override
    public User findByIdAndEmail(Email email) {
        return sqlSession.getMapper(UserRepository.class).findByIdAndEmail(email);
    }

    @Override
    public boolean update(User user) {
        return sqlSession.getMapper(UserRepository.class).update(user) == 1;
    }

    @Override
    public boolean delete(String userid) {
        return sqlSession.getMapper(UserRepository.class).delete(userid) == 1;
    }

    @Override
    public List<User> selectAll() {
        return sqlSession.getMapper(UserRepository.class).selectAll();
    }

    @Override
    public boolean updatePassword(Map map) {
        return sqlSession.getMapper(UserRepository.class).updatePassword(map) == 1;
    }
}
