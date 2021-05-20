package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.Notice;
import com.ssafy.happyhouse.model.repository.NoticeRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Notice> selectAll() {
        return sqlSession.getMapper(NoticeRepository.class).selectAll();
    }

    @Override
    public boolean insert(Notice notice) {
        return sqlSession.getMapper(NoticeRepository.class).insert(notice) == 1;
    }
}
