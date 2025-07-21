package com.openclassrooms.rentalsapi.controller;

import com.openclassrooms.rentalsapi.DTO.MessageDTO;
import com.openclassrooms.rentalsapi.model.MessageRequest;
import com.openclassrooms.rentalsapi.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/messages")
    @Operation(summary = "Profil utilisateur", description = "Récupère les informations de l'utilisateur connecté")
    @SecurityRequirement(name = "bearerAuth")
    public MessageDTO posMessage(@RequestBody MessageRequest messageRequest){
       return messageService.saveMessage(messageRequest);
    }
}
