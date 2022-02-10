package com.example.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ReqMail {
    private String toAddress;
    private String title;
    private String content;
}
