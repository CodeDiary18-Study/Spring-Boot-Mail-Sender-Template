package com.example.mail.service;

import com.example.mail.config.BaseException;
import com.example.mail.dto.ReqMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private final JavaMailSender mailSender;

    @Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Value("${spring.mail.nickname} <${spring.mail.username}>")
    private String FROM;


    public void sendMail(ReqMail reqMail) throws BaseException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(FROM);
            helper.setSubject(reqMail.getTitle());
            helper.setText(reqMail.getContent());
            helper.setTo(reqMail.getToAddress());

            mailSender.send(message);
        } catch (MailAuthenticationException e) {
            e.printStackTrace();
            throw new BaseException("서버 메일 계정 인증에 실패했습니다.");
        } catch (Exception e) {
            throw new BaseException("이메일 전송하는 과정에서 문제가 발생했습니다.");
        }
    }
}