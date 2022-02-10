package com.example.mail.controller;

import com.example.mail.config.BaseException;
import com.example.mail.dto.ReqMail;
import com.example.mail.dto.Res;
import com.example.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * 메일 전송 API
     *
     * @param reqMail
     * @return
     */
    @PostMapping("/send")
    public Res sendMail(@RequestBody ReqMail reqMail) {
        try {
            mailService.sendMail(reqMail);
            return new Res(true, "메일 전송에 성공했습니다!");
        } catch (BaseException e) {
            return new Res(false, e.getErr_msg());
        }
    }
}
