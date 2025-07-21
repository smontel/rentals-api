package com.openclassrooms.rentalsapi.controller;

import java.awt.*;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import com.openclassrooms.rentalsapi.DTO.MessageDTO;
import com.openclassrooms.rentalsapi.DTO.RentalDTO;
import com.openclassrooms.rentalsapi.DTO.RentalListDTO;
import com.openclassrooms.rentalsapi.mapper.RentalMapper;
import com.openclassrooms.rentalsapi.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.openclassrooms.rentalsapi.model.Rental;
import com.openclassrooms.rentalsapi.service.RentalService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;
    @Autowired
    private RentalMapper rentalMapper;
    @Autowired
    private ImageService imageService;


    @GetMapping("/{id}")
    @Operation(summary = "Rental par ID", description = "Récupère un rental particulier en specifiant son ID")
    @SecurityRequirement(name = "bearerAuth")
    public Optional<Rental> getRental(@PathVariable Long id) {
        return rentalService.getRental(id);
    }

    @GetMapping("")
    @Operation(summary = "Rentals", description = "Récupère tout es rentals préents en base de donnée")
    @SecurityRequirement(name = "bearerAuth")
    public RentalListDTO getAllRentals() {
        RentalListDTO rentals = new RentalListDTO();
        rentals.setRentals(rentalMapper.toDTOList(rentalService.getRentals()));
        return rentals;

    }

    @PostMapping(value="", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Création de rental", description = "créer un nouveau rental et l'enregistre en BDD")
    @SecurityRequirement(name = "bearerAuth")
    public MessageDTO createRental(
            Principal principal,
            @RequestParam("name") String name,
            @RequestParam("surface") Integer surface,
            @RequestParam("price") Integer price,
            @RequestParam("description") String description,
            @RequestParam(value = "picture", required = false) MultipartFile picture
    ) throws IOException {
        Rental rental = new Rental();
        rental.setName(name);
        rental.setSurface(surface);
        rental.setPrice(price);
        rental.setDescription(description);

        if (picture != null && !picture.isEmpty()) {
            rental.setPicture(imageService.saveAndGetUrl(picture));

        }
        return rentalService.saveRental(rental);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modification de retal", description = "Modification d'un rental en utilisqnt son ID")
    @SecurityRequirement(name = "bearerAuth")
    public MessageDTO updateRental(@PathVariable Long id, @RequestBody RentalDTO rental) {
       rental.setId(id);
      // rentalService.saveRental(rental);
       MessageDTO success=new MessageDTO();
       success.setMessage("Rental updated !");
       return success;
    }
}
