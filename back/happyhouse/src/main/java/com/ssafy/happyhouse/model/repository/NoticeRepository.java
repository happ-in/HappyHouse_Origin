package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.Notice;

import java.util.List;

public interface NoticeRepository {
    // 글 불러오기
    List<Notice> selectAll();

    // 글 등록
    int insert(Notice notice);

    // 글 단건조회
    Notice selectOne(int noticeno);
}
