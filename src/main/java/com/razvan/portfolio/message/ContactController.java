package com.razvan.portfolio.message;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/api/contact")
    public ResponseEntity<Void> receiveContact(@Valid @RequestBody ContactRequest request) {
        emailService.sendContactEmail(request.name(), request.email(), request.message());
        return ResponseEntity.ok().build();
    }
}
