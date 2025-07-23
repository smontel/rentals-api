package com.openclassrooms.rentalsapi.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageRequestDTO {
    private String message;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("rental_id")
    private int rentalId;
}
