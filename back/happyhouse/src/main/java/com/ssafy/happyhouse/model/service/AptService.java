package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.Apt;
import com.ssafy.happyhouse.model.domain.AptPrice;

import java.util.List;

public interface AptService {
    List<Apt> findByDong(String dong);
    List<Apt> findByDealAmount(AptPrice aptPrice);
}
