package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.Apt;
import com.ssafy.happyhouse.model.domain.AptPrice;

import java.util.List;

public interface AptRepository {
    List<Apt> findByDong(String dong);
    List<Apt> findByDealAmount(AptPrice aptPrice);
}
