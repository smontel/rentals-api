package com.openclassrooms.rentalsapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Blob;
import java.time.LocalDate;


import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int surface;

    private int price;

    private String picture;

    private String description;

    @Column(name="owner_id")
    private long ownerId;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDate updatedAt;


}
