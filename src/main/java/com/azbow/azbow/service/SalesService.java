package com.azbow.azbow.service;

import com.azbow.azbow.entity.Lead;
import com.azbow.azbow.entity.Sale;
import com.azbow.azbow.repository.LeadRepository;
import com.azbow.azbow.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SalesService {
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    LeadRepository leadRepository;
    public Map<String, Object> createSales(Map<String, Object> sales) {
        Map<String, Object> response = new HashMap<>();
        Sale sale = new Sale();
        Integer leadId = (Integer)sales.get("leadId");
        Optional<Lead> lead = leadRepository.findById(Long.valueOf(leadId));

        if(lead.isPresent()){
            sale.setSaleDate(LocalDate.parse(sales.get("saleDate").toString()));
            sale.setLead(lead.get());
            sale.setSalePrice(Double.valueOf((Integer) sales.get("finalPrice")));
            try {
                Sale save = salesRepository.save(sale);
                response.put("saleId", save.getSaleId());
                response.put("message", "Sale created successfully");
            } catch (Exception e) {
                e.printStackTrace();
                response.put("message", "Sale creation failed");

            }
        }else{
            response.put("message", "Lead not found");
        }

        return  response;

    }
}
