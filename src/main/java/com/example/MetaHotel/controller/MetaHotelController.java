package com.example.MetaHotel.controller;

import com.example.MetaHotel.entity.Hotel;
import com.example.MetaHotel.entity.MetaHotel;
import com.example.MetaHotel.service.HotelService;
import com.example.MetaHotel.service.MetaHotelService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/metaHotel")
public class MetaHotelController {
    MetaHotelService metaHotelService;
    HotelService hotelService;

    @PostMapping("/create")
    public MetaHotel createHotels(@RequestBody MetaHotel metaHotel){
        return metaHotelService.createMetaHotel(metaHotel);
    }
    @GetMapping("/getAllMetaHotels")
    public List<MetaHotel> getAllMetaHotels(){
        return metaHotelService.getAllMetaHotels();
    }
    @GetMapping("/getMetaHotelById")
    public MetaHotel getMetaHotelById(@PathVariable Long id){
        return metaHotelService.getMetaHotelById(id);
    }


}
