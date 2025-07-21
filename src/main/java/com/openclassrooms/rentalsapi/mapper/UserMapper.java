package com.openclassrooms.rentalsapi.mapper;

import com.openclassrooms.rentalsapi.DTO.UserDTO;
import com.openclassrooms.rentalsapi.model.DBUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(DBUser user){
        UserDTO dto= new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;
    }
}
