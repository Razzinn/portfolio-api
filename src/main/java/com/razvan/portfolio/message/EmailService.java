package com.razvan.portfolio.message;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactEmail(String fromName, String fromEmail, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("ig.razvan12@gmail.com");
        mail.setSubject("Nuovo contatto dal portfolio — " + fromName);
        mail.setText("""
            Nome: %s
            Email: %s
            Messaggio:
            %s
            """.formatted(fromName, fromEmail, message));
        mailSender.send(mail);
    }
}
