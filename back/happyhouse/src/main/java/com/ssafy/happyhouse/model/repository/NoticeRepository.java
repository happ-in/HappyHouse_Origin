package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.Notice;
import com.ssafy.happyhouse.model.domain.Search;

import java.util.List;

public interface NoticeRepository {
    // 글 불러오기
    List<Notice> selectAll(int offset);

    // 글 등록
    int insert(Notice notice);

    // 글 단건조회
    Notice selectOne(int noticeno);

    int count();

    // 키워드로 검색
    List<Notice> findByKeyword(Search search);

    // 키워드로 검색글 수
    int findByKeywordCount(Search search);

    // 삭제
    int delete(int noticeno);
}
