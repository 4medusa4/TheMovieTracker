package com.themovietracker.TheMovieTracker.service.impl;

import com.themovietracker.TheMovieTracker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String fromEmail;
    @Autowired
    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(fromEmail);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setCc(cc);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(body);

            this.javaMailSender.send(simpleMailMessage);

//            for(int i=0; i<file.length; i++){
//                mimeMessageHelper.addAttachment(
//                        file[i].getOriginalFilename(),
//                        new ByteArrayResource(file[i].getBytes())
//                );
//            }
//            javaMailSender.send(sim);
//            return "mail sent";

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
