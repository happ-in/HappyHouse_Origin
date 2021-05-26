package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.QnaComment;

import java.util.List;

public interface QnaCommentService {
    // 댓글 등록
    boolean insert(QnaComment comment);

    // 댓글 조회
    List<QnaComment> searchAll(int qna_id);

    // 댓글 삭제
    boolean delete(int id);
}
