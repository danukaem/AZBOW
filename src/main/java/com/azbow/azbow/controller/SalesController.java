package com.azbow.azbow.controller;

import com.azbow.azbow.service.impl.SalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    SalesServiceImpl salesServiceImpl;

    @PostMapping
    public Map<String, Object> createSales(@RequestBody Map<String, Object> sales) {
        return salesServiceImpl.createSales(sales);
    }
}
