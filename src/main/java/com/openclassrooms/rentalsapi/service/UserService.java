package com.openclassrooms.rentalsapi.service;


import com.openclassrooms.rentalsapi.model.DBUser;
import com.openclassrooms.rentalsapi.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<DBUser> getUserByMail(final String email) { return userRepository.findByEmail(email); }

    public Optional<DBUser> getUser(final Long id) { return userRepository.findById(id); }

    public Iterable<DBUser> getUsers() {return userRepository.findAll(); }

}
