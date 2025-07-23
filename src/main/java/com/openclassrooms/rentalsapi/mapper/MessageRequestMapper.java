package com.openclassrooms.rentalsapi.mapper;

import com.openclassrooms.rentalsapi.DTO.MessageRequestDTO;
import com.openclassrooms.rentalsapi.DTO.UserDTO;
import com.openclassrooms.rentalsapi.model.DBUser;
import com.openclassrooms.rentalsapi.model.MessageRequest;
import org.springframework.stereotype.Component;

@Component
public class MessageRequestMapper {
    public MessageRequest toEntity(MessageRequestDTO messageRequestDTO){
        MessageRequest entity= new MessageRequest();
        entity.setUserId(messageRequestDTO.getUserId());
        entity.setMessage(messageRequestDTO.getMessage());
        entity.setRentalId(messageRequestDTO.getRentalId());

        return entity;
    }
}
