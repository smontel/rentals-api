package com.openclassrooms.rentalsapi.repository;

import com.openclassrooms.rentalsapi.model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<DBUser, Long> {

        Optional<DBUser> findByEmail(String email);

}
