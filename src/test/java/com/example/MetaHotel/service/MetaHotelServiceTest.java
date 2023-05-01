package com.example.MetaHotel.service;

import com.example.MetaHotel.entity.MetaHotel;
import com.example.MetaHotel.repository.MetaHotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MetaHotelServiceTest {
    @Mock
    private MetaHotelRepository metaHotelRepository;

    @InjectMocks
    private MetaHotelService metaHotelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMetaHotelById() {
        Long id = 1L;
        MetaHotel metaHotel = new MetaHotel();
        metaHotel.setId(id);

        when(metaHotelRepository.findById(id)).thenReturn(Optional.of(metaHotel));

        MetaHotel result = metaHotelService.getMetaHotelById(id);

        assertEquals(metaHotel, result);
    }

    @Test
    public void testGetMetaHotelByIdNotFound() {
        Long id = 1L;

        when(metaHotelRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> metaHotelService.getMetaHotelById(id));
    }
}
