package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.Qna;

import java.util.List;

public interface QnaRepository {
    // 전체조회
    List<Qna> selectAll();

    // 단건조회
    Qna selectOne(int id);

    // 수정
    int update(Qna qna);

    // 삭제
    int delete(int id);

    // 등록
    int insert(Qna qna);
}
