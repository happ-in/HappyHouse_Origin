package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.Qna;
import com.ssafy.happyhouse.model.domain.Search;

import java.util.List;

public interface QnaService {
    // 전체조회
    List<Qna> selectAll(int offset);

    // 단건조회
    Qna selectOne(int id);

    // 수정
    boolean update(Qna qna);

    // 삭제
    boolean delete(int id);

    // 등록
    boolean insert(Qna qna);

    // 전체 글 개수
    int count();

    // 검색
    List<Qna> findByKeyword(Search search);

    // 검색 카운트
    int findByKeywordCount(Search search);
}
