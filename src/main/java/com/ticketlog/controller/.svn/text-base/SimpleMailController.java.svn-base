package com.ticketlog.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleMailController {
    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/sendMail")
    public ModelAndView sendMail() {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo("er.chandrasekharyadav@gmail.com");
            helper.setText("you have raise a ticket :)");
            helper.setSubject("Mail From spring ticketLog");
        } catch (MessagingException e) {
            e.printStackTrace();
           
        }
        sender.send(message);
        return new ModelAndView("login");
    }
}
