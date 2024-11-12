package com.example.f10_pagingSorting.apiControllers;

import com.example.f10_pagingSorting.db.CityRepository;
import com.example.f10_pagingSorting.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping("/api")
    public Map<String, Object> root(
            @RequestParam(name="page", required = false, defaultValue = "1") Integer urlPageNumber
    ) {
        int pageNumber = urlPageNumber - 1;

        Pageable pageable = PageRequest.of(pageNumber, 20);
        Page<City> page = cityRepository.findAll(pageable);

        return Map.of(
                "count", page.getTotalElements(),
                "results", page.getContent(),
                "page", page.getNumber() + 1,
                "totalPages", page.getTotalPages()
        );

    }
}
