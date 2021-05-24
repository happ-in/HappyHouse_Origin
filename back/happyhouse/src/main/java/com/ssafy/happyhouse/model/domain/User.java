package com.ssafy.happyhouse.model.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class User {
    private String userid;
    private String username;
    private String userpwd;
    private String email;
    private String address;
    private LocalDate joindate;
    private String role;
    private String folder;
    private String filename;
}
