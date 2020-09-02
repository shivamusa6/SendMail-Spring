package com.store.email.controller;

import com.store.email.model.EmailResponse;
import com.store.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    /**
     * @param email
     * @return EmailResponse
     */
    @GetMapping(value = "/sendmail")
    public EmailResponse sendmail(@RequestParam String email) {
        return emailService.sendMail(email, "DEIMDEI", ",message");
    }

    /**
     * @param emailList
     * @return List<EmailResponse>
     */
    @PostMapping(value = "/sendmail")
    public List<EmailResponse> sendCommonMail(@RequestBody List<String> emailList) {
        return emailService.sendCommonBulkMail(emailList, "DEIMDEI", ",message");
    }
}
