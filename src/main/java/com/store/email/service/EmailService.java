package com.store.email.service;

import com.store.email.model.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Compose the mail
     */
    public SimpleMailMessage composeMail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        return mailMessage;
    }

    /**
     * Send the a Mail
     */
    public EmailResponse sendMail(String toEmail, String subject, String message) {
        EmailResponse response = new EmailResponse();
        response.setEmailId(toEmail);
        try {
            javaMailSender.send(composeMail(toEmail, subject, message));
            response.setDelivered(Boolean.TRUE);
        } catch (Exception e) {
            response.setDelivered(Boolean.FALSE);
        }
        return response;
    }

    /**
     * Send Bulk Mail
     *
     * @param emailList list of valid emailid
     */
    public List<EmailResponse> sendCommonBulkMail(List<String> emailList, String subject, String message) {
        List<EmailResponse> responses = new ArrayList<>();
        emailList.parallelStream().forEach(mail -> {
            responses.add(sendMail(mail, subject, message));
        });
        return responses;
    }
}
