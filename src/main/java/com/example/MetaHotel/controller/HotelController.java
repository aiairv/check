package com.example.MetaHotel.controller;

import com.example.MetaHotel.entity.Hotel;
import com.example.MetaHotel.entity.MetaHotel;
import com.example.MetaHotel.repository.HotelRepository;
import com.example.MetaHotel.repository.MetaHotelRepository;
import com.example.MetaHotel.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/hotel")
public class HotelController {
    HotelService hotelService;
    MetaHotelRepository metaHotelRepository;

    @PostMapping("/create")
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }
    @PostMapping("rebindHotel/{hotelId}/{metaHotelId}")
    public Hotel rebindHotel(@PathVariable Long hotelId, @PathVariable Long metaHotelId){
        return hotelService.rebindHotel(hotelId, metaHotelId);
    }
}
