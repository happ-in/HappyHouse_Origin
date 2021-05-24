package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Email;
import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.service.FileService;
import com.ssafy.happyhouse.model.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ssafy.happyhouse.utils.StringUtil.*;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired UserService service;
    @Autowired
    JavaMailSender sender;

    @PostMapping
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(service.findByIdAndPassword(user), HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody User user) {
        if (service.join(user)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> IdCheck(HttpServletRequest request) {
        String userid = request.getParameter("id");
        if (service.findByIdList(userid)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/find")
    public ResponseEntity<String> findPassword(@RequestBody Email email) {
        if (service.findByIdAndEmail(email) != null) {
            String password = findPassWord(email.getEmail());
            Map<String, String> map = new HashMap<>();
            map.put("userid", email.getUserid());
            map.put("userpwd", password);
            if (service.updatePassword(map)) {
                return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Async
    public String findPassWord(String email) {
        String password = randPassword();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SEND_EMAIL);
        message.setTo(email);
        message.setSubject("[내집마련] 임시 비밀번호입니다.");
        message.setText("임시 비밀번호는 [ " + password +" ]입니다.");
        message.setSentDate(new Date());
        sender.send(message);
        return password;
    }

    public String randPassword() {
        char[] chars = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) sb.append(chars[(int) (chars.length * Math.random())]);
        return sb.toString();
    }
}
