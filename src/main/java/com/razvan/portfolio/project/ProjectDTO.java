package com.razvan.portfolio.project;

import java.util.List;

public record ProjectDTO(
        Long id,
        String title,
        String description,
        List<String> technologies,
        String githubUrl,
        String demoUrl,
        String imageUrl
) {}
