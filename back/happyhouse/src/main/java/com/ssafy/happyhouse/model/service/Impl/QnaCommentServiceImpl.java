package com.ssafy.happyhouse.model.service.Impl;

import com.ssafy.happyhouse.model.domain.QnaComment;
import com.ssafy.happyhouse.model.repository.QnaCommentRepository;
import com.ssafy.happyhouse.model.service.QnaCommentService;
import com.ssafy.happyhouse.model.service.QnaService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaCommentServiceImpl implements QnaCommentService {

    @Autowired private SqlSession sqlSession;

    @Override
    public boolean insert(QnaComment comment) {
        return sqlSession.getMapper(QnaCommentRepository.class).insert(comment) == 1;
    }

    @Override
    public List<QnaComment> searchAll(int qna_id) {
        return sqlSession.getMapper(QnaCommentRepository.class).searchAll(qna_id);
    }

    @Override
    public boolean delete(int id) {
        return sqlSession.getMapper(QnaCommentRepository.class).delete(id) == 1;
    }
}
