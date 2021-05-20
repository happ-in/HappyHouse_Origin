package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.Qna;

import java.util.List;

public interface QnaService {
    // 전체조회
    List<Qna> selectAll();

    // 단건조회
    Qna selectOne(int id);

    // 수정
    boolean update(Qna qna);

    // 삭제
    boolean delete(int id);

    // 등록
    boolean insert(Qna qna);
}
