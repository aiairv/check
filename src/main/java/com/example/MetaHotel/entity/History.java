package com.example.MetaHotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "meta_hotel_id", nullable = false)
    private MetaHotel metaHotel;
    @Column(name = "moved_date", nullable = false)
    private LocalDateTime movedDate;

    public History(Hotel hotel, MetaHotel metaHotel) {
    }
}
