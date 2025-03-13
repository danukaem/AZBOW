package com.azbow.azbow.controller;

import com.azbow.azbow.entity.Property;
import com.azbow.azbow.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping
    public Map<String, Object> createProperty(@RequestBody Property property) {
        return propertyService.save(property);
    }

}
