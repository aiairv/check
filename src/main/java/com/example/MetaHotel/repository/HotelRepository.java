package com.example.MetaHotel.repository;

import com.example.MetaHotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
