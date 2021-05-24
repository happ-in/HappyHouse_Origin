package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.FileInfo;

public interface FileRepository {
    int save(FileInfo image);
    int update(FileInfo image);
    FileInfo findById(String userid);
    int delete(String userid);
}
