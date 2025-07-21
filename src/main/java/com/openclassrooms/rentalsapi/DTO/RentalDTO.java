package com.openclassrooms.rentalsapi.DTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RentalDTO {
    private Long id;
    private String name;
    private int surface;
    private int price;
    private String picture;
    private String description;
    private long ownerId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
