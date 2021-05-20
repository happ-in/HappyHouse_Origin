package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.QnaComment;

import java.util.List;

public interface QnaCommentRepository {
    // 댓글 등록
    int insert(QnaComment comment);

    // 댓글 조회
    List<QnaComment> searchAll(int qna_id);

    // 댓글 삭제
    int delete(int id);
}
