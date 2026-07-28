package com.razvan.portfolio.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;

    public List<ProjectDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public Optional<ProjectDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    private ProjectDTO toDTO(Project p) {
        List<String> techs = p.getTechnologies() != null
                ? Arrays.asList(p.getTechnologies().split(","))
                : List.of();
        return new ProjectDTO(p.getId(), p.getTitle(), p.getDescription(),
                techs, p.getGithubUrl(), p.getDemoUrl(), p.getImageUrl());
    }
}
