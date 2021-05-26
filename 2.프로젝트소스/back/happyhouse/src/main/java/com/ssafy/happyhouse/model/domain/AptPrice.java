package com.ssafy.happyhouse.model.domain;

import lombok.Data;

@Data
public class AptPrice {
    private String dong;
    private int min;
    private int max;

    public AptPrice(String dong, int min, int max) {
        this.dong = dong;
        this.min = min;
        this.max = max;
    }
}
