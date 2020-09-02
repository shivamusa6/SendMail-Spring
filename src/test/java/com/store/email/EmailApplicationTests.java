package com.store.email;

import com.store.email.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EmailApplicationTests {

    @Autowired
    private EmailService emailService;

    /**
     Testing Send email functionality
     */
    @Test
    public void testEmail() {
        System.out.println(emailService.sendMail("shivamusa6@gmail.com", "Test subject", "Test mail"));
    }

    /**
        Testing Bulk Send email functionality
     */
    @Test
    public void testCommonEmail() {
        List<String> emailList = new ArrayList<>();
        emailList.add("shivamusa63u23ue230e83@");
        emailList.add("shivamusa666@gmail.com");
        System.out.println(emailService.sendCommonBulkMail(emailList, "Test Bulk", "Testing"));
    }

}
