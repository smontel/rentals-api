package com.openclassrooms.rentalsapi.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "messages")
public class MessageRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rental_id")
    private int rentalId;

    @Column(name="user_id")
    private int userId;

    private String message;
}