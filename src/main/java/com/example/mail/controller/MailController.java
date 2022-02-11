package com.example.mail.controller;

import com.example.mail.config.BaseException;
import com.example.mail.dto.ReqMail;
import com.example.mail.dto.Res;
import com.example.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

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
     * @return Res
     */
    @PostMapping("/send")
    public Res sendMail(@RequestBody @Valid ReqMail reqMail, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {    // request에 문제가 있을 경우
            List<ObjectError> errorList = bindingResult.getAllErrors();
            HashMap<String, String> err_msg = new HashMap<>();
            for (ObjectError error : errorList) {
                err_msg.put(((FieldError) error).getField(), error.getDefaultMessage());
            }
            return new Res(false, err_msg);
        }
        try {
            mailService.sendMail(reqMail);
            return new Res(true, "메일 전송에 성공했습니다!");
        } catch (BaseException e) {
            return new Res(false, e.getErr_msg());
        }
    }
}
