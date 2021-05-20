package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.Notice;

import java.util.List;

public interface NoticeService {
    // 글 불러오기
    List<Notice> selectAll();

    // 글 등록
    boolean insert(Notice notice);
}
