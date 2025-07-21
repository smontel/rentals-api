package com.openclassrooms.rentalsapi.mapper;
import com.openclassrooms.rentalsapi.DTO.RentalDTO;
import com.openclassrooms.rentalsapi.model.Rental;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalMapper {
    public RentalDTO toDTO(Rental rental) {
        RentalDTO dto = new RentalDTO();
        dto.setId(rental.getId());
        dto.setName(rental.getName());
        dto.setSurface(rental.getSurface());
        dto.setPrice(rental.getPrice());
        dto.setPicture(rental.getPicture());
        dto.setDescription(rental.getDescription());
        dto.setOwnerId(rental.getOwnerId());
        dto.setCreatedAt(rental.getCreatedAt());
        dto.setUpdatedAt(rental.getUpdatedAt());

        return dto;
    }

    public Rental toEntity(RentalDTO dto) {
        Rental rental = new Rental();
        rental.setId(dto.getId());
        rental.setName(dto.getName());
        rental.setSurface(dto.getSurface());
        rental.setPrice(dto.getPrice());
        rental.setPicture(dto.getPicture());
        rental.setOwnerId(dto.getOwnerId());
        rental.setCreatedAt(dto.getCreatedAt());
        rental.setUpdatedAt(dto.getUpdatedAt());
        return rental;
    }

    public List<RentalDTO> toDTOList(List<Rental> rentals) {
        return rentals.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Rental> toEntityList(List<RentalDTO> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
