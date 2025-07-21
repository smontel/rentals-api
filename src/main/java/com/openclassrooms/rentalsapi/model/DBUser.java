package com.openclassrooms.rentalsapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;


@Entity
@Table(name="user")
@Data
public class DBUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String email;


    private String password;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDate updatedAt;

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return name;
    }

}
