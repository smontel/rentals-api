package com.openclassrooms.rentalsapi.repository;

import com.openclassrooms.rentalsapi.model.MessageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRequestRepository extends JpaRepository<MessageRequest, Long> {

}
