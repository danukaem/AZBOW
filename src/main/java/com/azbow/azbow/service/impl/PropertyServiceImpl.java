package com.azbow.azbow.service.impl;

import com.azbow.azbow.entity.Property;
import com.azbow.azbow.repository.PropertyRepository;
import com.azbow.azbow.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    public Map<String, Object> save(Property property) {
        Property save = propertyRepository.save(property);
        Map<String, Object> response = new HashMap<>();
        response.put("propertyId", save.getPropertyId());
        response.put("message", "Property created successfully");
        return response;
    }
}
