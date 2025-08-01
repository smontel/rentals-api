package com.openclassrooms.rentalsapi.repository;

import com.openclassrooms.rentalsapi.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
