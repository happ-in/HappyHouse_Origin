package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.FileInfo;

public interface FileService {
    boolean save(FileInfo image);
    boolean update(FileInfo image);
    FileInfo findById(String userid);
    boolean delete(String userid);
}
