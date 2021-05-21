package com.ssafy.happyhouse.model.service.Impl;

import com.ssafy.happyhouse.model.domain.Qna;
import com.ssafy.happyhouse.model.domain.Search;
import com.ssafy.happyhouse.model.repository.QnaRepository;
import com.ssafy.happyhouse.model.service.QnaService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaServiceImpl implements QnaService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Qna> selectAll(int offset) { return sqlSession.getMapper(QnaRepository.class).selectAll(offset); }

    @Override
    public Qna selectOne(int id) {
        return sqlSession.getMapper(QnaRepository.class).selectOne(id);
    }

    @Override
    public boolean update(Qna qna) {
        return sqlSession.getMapper(QnaRepository.class).update(qna) == 1;
    }

    @Override
    public boolean delete(int id) {
        return sqlSession.getMapper(QnaRepository.class).delete(id) == 1;
    }

    @Override
    public boolean insert(Qna qna) {
        return sqlSession.getMapper(QnaRepository.class).insert(qna) == 1;
    }

    @Override
    public int count() { return sqlSession.getMapper(QnaRepository.class).count(); }

    @Override
    public List<Qna> findByKeyword(Search search) { return sqlSession.getMapper(QnaRepository.class).findByKeyword(search); }


    @Override
    public int findByKeywordCount(Search search) { return sqlSession.getMapper(QnaRepository.class).findByKeywordCount(search); }

}
