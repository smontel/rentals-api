package com.openclassrooms.rentalsapi.service;

import java.util.Optional;

import com.openclassrooms.rentalsapi.DTO.MessageDTO;
import com.openclassrooms.rentalsapi.repository.MessageRequestRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import com.openclassrooms.rentalsapi.model.MessageRequest;
import org.springframework.stereotype.Service;

@Data
@Service
public class MessageService {

    @Autowired
    private MessageRequestRepository messageRequestRepository;

    public Optional<MessageRequest> getMessage(final Long id) {
        return messageRequestRepository.findById(id);
    }

    public void deleteMessage(final Long id) {
        messageRequestRepository.deleteById(id);
    }

    public MessageDTO saveMessage(MessageRequest messageRequest) {
        MessageDTO messageSuccess = new MessageDTO();
        messageSuccess.setMessage("Message send with success");
        MessageRequest saveMessageRequest = messageRequestRepository.save(messageRequest);
        return messageSuccess;
    }
}


