package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.Apt;

import java.util.List;

public interface AptRepository {
    List<Apt> findByDong(String dong);
}
