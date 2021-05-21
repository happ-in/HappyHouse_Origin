package com.ssafy.happyhouse.model.service.Impl;

import com.ssafy.happyhouse.model.domain.Notice;
import com.ssafy.happyhouse.model.domain.Search;
import com.ssafy.happyhouse.model.repository.NoticeRepository;
import com.ssafy.happyhouse.model.service.NoticeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Notice> selectAll(int offset) {
        return sqlSession.getMapper(NoticeRepository.class).selectAll(offset);
    }

    @Override
    public boolean insert(Notice notice) {
        return sqlSession.getMapper(NoticeRepository.class).insert(notice) == 1;
    }

    @Override
    public Notice selectOne(int noticeno) {
        return sqlSession.getMapper(NoticeRepository.class).selectOne(noticeno);
    }

    @Override
    public int count() {
        return sqlSession.getMapper(NoticeRepository.class).count();
    }

    @Override
    public List<Notice> findByKeyword(Search search) {
        return sqlSession.getMapper(NoticeRepository.class).findByKeyword(search);
    }

    @Override
    public int findByKeywordCount(Search search) {
        return sqlSession.getMapper(NoticeRepository.class).findByKeywordCount(search);
    }

    @Override
    public boolean delete(int noticeno) {
        return sqlSession.getMapper(NoticeRepository.class).delete(noticeno) == 1;
    }
}
