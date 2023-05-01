package com.example.MetaHotel.service;

import com.example.MetaHotel.entity.History;
import com.example.MetaHotel.entity.Hotel;
import com.example.MetaHotel.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService {
    HistoryRepository historyRepository;
    public List<History> getHistory() {
        return historyRepository.findAll();
    }
}
