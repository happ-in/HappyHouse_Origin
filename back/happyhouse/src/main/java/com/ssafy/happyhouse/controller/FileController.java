package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.FileInfo;
import com.ssafy.happyhouse.model.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static com.ssafy.happyhouse.utils.StringUtil.FAIL;
import static com.ssafy.happyhouse.utils.StringUtil.SUCCESS;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService service;

    @PostMapping
    public ResponseEntity<String> UserImage(MultipartFile file, HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String today = new SimpleDateFormat("yyMMdd").format(new Date());
        String saveFolder = "C:\\happyhouse\\" + today;
        File folder = new File(saveFolder);
        if(!folder.exists()) folder.mkdirs();
        String origin = file.getOriginalFilename();
        String saveFileName = UUID.randomUUID().toString() + origin.substring(origin.lastIndexOf('.')).toLowerCase();
        try {
            file.transferTo(new File(folder, saveFileName));
            FileInfo image = new FileInfo();
            image.setUserid(userid);
            image.setFilename(saveFileName);
            image.setFolder(today);
            if (service.findById(userid) == null) {
                if (service.save(image)) return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
            } else {
                if (service.update(image)) return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<FileInfo> findById(@RequestParam("userid") String userid) {
        FileInfo file = service.findById(userid);
        if (file == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }
}
