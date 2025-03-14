package com.azbow.azbow.controller;

import com.azbow.azbow.entity.Property;
import com.azbow.azbow.service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyServiceImpl;

    @PostMapping
    public Map<String, Object> createProperty(@RequestBody Property property) {
        return propertyServiceImpl.save(property);
    }

}
