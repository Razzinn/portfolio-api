package com.razvan.portfolio;

import com.razvan.portfolio.project.Project;
import com.razvan.portfolio.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProjectRepository projectRepository;

    @Override
    public void run(String... args) {
        projectRepository.deleteAll();
        projectRepository.flush();

        projectRepository.saveAll(List.of(
            Project.builder()
                .title("Art.E")
                .description("Applicazione web per la scoperta e fruizione di contenuti artistici digitali. Interfaccia moderna con focus su visual design, animazioni e navigazione fluida tra le opere.")
                .technologies("React,JavaScript,Vite,Framer Motion,CSS3")
                .githubUrl("https://github.com/Razzinn/Art.E")
                .demoUrl("https://razzinn.github.io/Art.E")
                .imageUrl("/projects/arte.jpg")
                .build(),

            Project.builder()
                .title("DU'A")
                .description("Applicazione orientata al mondo spirituale/ispirazionale con gestione di contenuti testuali, liste e preferiti. Pensata per l'utilizzo mobile-first con UI pulita e leggibile.")
                .technologies("React,JavaScript,CSS Modules,Responsive Design")
                .githubUrl("https://github.com/Razzinn/DU-A-")
                .demoUrl("https://razzinn.github.io/DUA")
                .imageUrl("/projects/dua.jpg")
                .build()
        ));
    }
}
