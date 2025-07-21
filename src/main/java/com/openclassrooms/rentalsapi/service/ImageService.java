package com.openclassrooms.rentalsapi.service;

import com.openclassrooms.rentalsapi.model.Image;
import com.openclassrooms.rentalsapi.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public String saveAndGetUrl(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setData(file.getBytes());

        Image saved = imageRepository.save(image);

        return "http://localhost:3001/api/images/" + saved.getId();
    }
}
