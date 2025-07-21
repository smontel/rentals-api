package com.openclassrooms.rentalsapi.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class  RentalListDTO {
    List<RentalDTO> rentals;
}
