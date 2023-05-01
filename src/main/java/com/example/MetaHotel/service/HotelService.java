package com.example.MetaHotel.service;

import com.example.MetaHotel.entity.History;
import com.example.MetaHotel.entity.Hotel;
import com.example.MetaHotel.entity.MetaHotel;
import com.example.MetaHotel.repository.HistoryRepository;
import com.example.MetaHotel.repository.HotelRepository;
import com.example.MetaHotel.repository.MetaHotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class HotelService {
    HotelRepository hotelRepository;
    MetaHotelRepository metaHotelRepository;
    HistoryRepository historyRepository;


    public Hotel createHotel(Hotel hotel) {
        Long metaHotelId = hotel.getMetaHotel().getId();
        MetaHotel metaHotel = metaHotelRepository.findById(metaHotelId).orElseThrow(null);
        hotel.setMetaHotel(metaHotel);
        return hotelRepository.save(hotel);
    }

    public Hotel rebindHotel(Long hotelId, Long metaHotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException("Hotel with id " + hotelId + " not found"));
        MetaHotel metaHotel = metaHotelRepository.findById(metaHotelId)
                .orElseThrow(() -> new EntityNotFoundException("MetaHotel with id " + metaHotelId + " not found"));
        if (metaHotel.getHotels().contains(hotel)) {
            throw new IllegalArgumentException
                    ("Hotel with id " + hotelId + " is already bound to MetaHotel with id " + metaHotelId);
        }
            metaHotel.getHotels().add(hotel);
            metaHotelRepository.save(metaHotel);

            History history = new History(hotel, metaHotel);
            historyRepository.save(history);
            return history.getHotel();
    }
}

