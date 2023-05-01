package com.example.MetaHotel.repository;

import com.example.MetaHotel.entity.MetaHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaHotelRepository extends JpaRepository<MetaHotel, Long> {
}
