package com.ssafy.happyhouse.model.service.Impl;

import com.ssafy.happyhouse.model.domain.FileInfo;
import com.ssafy.happyhouse.model.repository.FileRepository;
import com.ssafy.happyhouse.model.service.FileService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired private SqlSession sqlSession;

    @Override
    public boolean save(FileInfo image) {
        return sqlSession.getMapper(FileRepository.class).save(image) == 1;
    }

    @Override
    public boolean update(FileInfo image) {
        return sqlSession.getMapper(FileRepository.class).update(image) == 1;
    }

    @Override
    public FileInfo findById(String userid) {
        return sqlSession.getMapper(FileRepository.class).findById(userid);
    }

    @Override
    public boolean delete(String userid) {
        return sqlSession.getMapper(FileRepository.class).delete(userid) == 1;
    }
}
