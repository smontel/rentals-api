package com.openclassrooms.rentalsapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.openclassrooms.rentalsapi.DTO.MessageDTO;
import com.openclassrooms.rentalsapi.DTO.RentalDTO;
import com.openclassrooms.rentalsapi.mapper.RentalMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import com.openclassrooms.rentalsapi.model.Rental;
import com.openclassrooms.rentalsapi.repository.RentalRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private RentalMapper rentalMapper;

    public Optional<Rental> getRental(final Long id) {
        return rentalRepository.findById(id);
    }

    public List<Rental> getRentals() {
        Iterable<Rental> rentalsIterable =rentalRepository.findAll();
        List<Rental> rentals = new ArrayList<>();
        rentalsIterable.forEach(rentals::add);
        return rentals;

    }

    public void deleteRental(final Long id) {
        rentalRepository.deleteById(id);
    }

    public MessageDTO saveRental(Rental rental) {
        rentalRepository.save(rental);
        MessageDTO success =new MessageDTO();
        success.setMessage("Rental created !");
        return success;
    }

    private String getPictureURL(Long rentalId){
        return "/rentals/"+ rentalId + "/picture";
    }

}
