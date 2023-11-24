package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/mail")
public class EmailSendController {

    private final EmailService emailService;

    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity sendMail(@RequestParam(value = "file", required = false)MultipartFile[] file, String to, String[] cc, String subject, String body){
        this.emailService.sendMail(file, to, cc, subject, body);
        return ResponseEntity.ok("Success");
    }
}
