package com.openclassrooms.rentalsapi.controller;

import com.openclassrooms.rentalsapi.model.Image;
import com.openclassrooms.rentalsapi.repository.ImageRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/images")

public class ImageController {
    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/{id}")
    @Operation(summary = "Image en BDD", description = "Récupère une image enregistré en BDD")
    public byte[] getImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Optional<Image> optionalImage = imageRepository.findById(id);

        if (optionalImage.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        Image image = optionalImage.get();
        response.setContentType(image.getType());
        return image.getData();
    }
}
