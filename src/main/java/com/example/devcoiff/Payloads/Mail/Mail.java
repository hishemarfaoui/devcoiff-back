package com.example.devcoiff.Payloads.Mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    protected String mailSubject;
    protected String mailMessage;
    protected String mailAddress;
}