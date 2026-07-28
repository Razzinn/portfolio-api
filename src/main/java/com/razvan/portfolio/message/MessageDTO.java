package com.razvan.portfolio.message;

import java.time.LocalDateTime;

public record MessageDTO(Long id, String name, String text, LocalDateTime createdAt) {}
