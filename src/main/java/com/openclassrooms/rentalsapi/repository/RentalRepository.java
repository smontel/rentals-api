package com.openclassrooms.rentalsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.openclassrooms.rentalsapi.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}