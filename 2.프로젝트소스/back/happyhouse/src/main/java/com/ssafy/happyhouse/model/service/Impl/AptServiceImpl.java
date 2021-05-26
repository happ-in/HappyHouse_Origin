package com.ssafy.happyhouse.model.service.Impl;

import com.ssafy.happyhouse.model.domain.Apt;
import com.ssafy.happyhouse.model.domain.AptPrice;
import com.ssafy.happyhouse.model.repository.AptRepository;
import com.ssafy.happyhouse.model.service.AptService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AptServiceImpl implements AptService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Apt> findByDong(String dong) {
        return sqlSession.getMapper(AptRepository.class).findByDong(dong);
    }

    @Override
    public List<Apt> findByDealAmount(AptPrice aptPrice) {
        return sqlSession.getMapper(AptRepository.class).findByDealAmount(aptPrice);
    }
}
