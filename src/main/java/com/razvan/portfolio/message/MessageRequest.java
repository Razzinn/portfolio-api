package com.razvan.portfolio.message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MessageRequest(
        @NotBlank(message = "Il nome non puo essere vuoto")
        @Size(max = 100, message = "Il nome non puo superare i 100 caratteri")
        String name,

        @NotBlank(message = "Il messaggio non puo essere vuoto")
        @Size(min = 2, max = 500, message = "Il messaggio deve essere tra 2 e 500 caratteri")
        String text
) {}
