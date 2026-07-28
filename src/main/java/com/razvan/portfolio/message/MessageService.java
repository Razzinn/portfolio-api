package com.razvan.portfolio.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public List<MessageDTO> findLatest() {
        return repository.findTop10ByOrderByCreatedAtDesc()
                .stream()
                .map(m -> new MessageDTO(m.getId(), m.getName(), m.getText(), m.getCreatedAt()))
                .toList();
    }

    public MessageDTO save(MessageRequest request) {
        Message message = Message.builder()
                .name(request.name())
                .text(request.text())
                .build();
        Message saved = repository.save(message);
        return new MessageDTO(saved.getId(), saved.getName(), saved.getText(), saved.getCreatedAt());
    }
}
