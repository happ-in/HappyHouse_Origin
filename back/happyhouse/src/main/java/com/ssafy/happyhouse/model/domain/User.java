package com.ssafy.happyhouse.model.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private String userid;
    private String username;
    private String userpwd;
    private String email;
    private String address;
    private LocalDate joindate;
}
