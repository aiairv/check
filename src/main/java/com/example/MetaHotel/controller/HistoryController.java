package com.example.MetaHotel.controller;

import com.example.MetaHotel.entity.History;
import com.example.MetaHotel.service.HistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    HistoryService historyService;
    @GetMapping()
    public List<History> getHistory(){
        return historyService.getHistory();
    }

}
