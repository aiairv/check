package com.example.MetaHotel.service;

import com.example.MetaHotel.entity.Hotel;
import com.example.MetaHotel.entity.MetaHotel;
import com.example.MetaHotel.repository.HotelRepository;
import com.example.MetaHotel.repository.MetaHotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MetaHotelService {
    MetaHotelRepository metaHotelRepository;
    public MetaHotel createMetaHotel(MetaHotel metaHotel){
        return metaHotelRepository.save(metaHotel);
    }
    public List<MetaHotel> getAllMetaHotels(){
        return metaHotelRepository.findAll();
    }
    public MetaHotel getMetaHotelById(Long id){
        return metaHotelRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("MetaHotel with Id: " + id + "not found"));
    }
}
