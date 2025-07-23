package com.openclassrooms.rentalsapi.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("owner_id")
    private long ownerId;
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
}
