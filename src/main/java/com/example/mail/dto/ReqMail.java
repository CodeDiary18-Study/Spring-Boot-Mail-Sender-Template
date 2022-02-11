package com.example.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ReqMail {
    @NotBlank
    @Email
    private String toAddress;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
