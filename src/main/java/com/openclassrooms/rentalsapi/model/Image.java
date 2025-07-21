package com.openclassrooms.rentalsapi.model;


import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

@Data
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type; // MIME type: image/jpeg, image/png, etc.

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
}
